package Controlador.cinehome;


import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import Dao.cinehome.BoletaImp;
import Dao.cinehome.EmpleadoImp;
import Dao.cinehome.PeliculaImp;
import Modelo.ClassPelicula;
import Modelo.Classempleado;

@MultipartConfig
/**
 * Servlet implementation class ControladorPelicula
 */
@WebServlet("/ControladorPelicula")
public class ControladorPelicula extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControladorPelicula() {
        super();
        // TODO Auto-generated constructor stub
    }

	PeliculaImp p = new PeliculaImp();
	private String pathFiles = "C:\\wamp\\www\\files\\";
	private File uploads = new File(pathFiles);
	private String[] extens = {".ico",".png",".jpg",".jpeg"};
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		switch(action){
		case "Grabar":
			savePelicula(request, response);
			break;
		case "Listar":
			List<ClassPelicula> ListadoPeliculas = p.ListarPelicula();
			request.setAttribute("ListadoPeliculas",ListadoPeliculas);
			request.getRequestDispatcher("/ListadoPelicula.jsp").forward(request,response);
			break;
			default:
				break;
			case "Modificar":
				int idpelicula = Integer.parseInt(request.getParameter("idpelicula"));
				//iniciamos las respectivas clases 
				ClassPelicula clapeli= new ClassPelicula();
				PeliculaImp crudpeli = new PeliculaImp();
				//inicializamos el codigo buscar 
				clapeli.setIdpelicula(idpelicula);
				ClassPelicula almpeli = crudpeli.BuscarPelicula(clapeli);
				//enviamos al formulario los datos 
				request.setAttribute("idpelicula",almpeli.getIdpelicula());
				request.setAttribute("nompelicula",almpeli.getNompelicula());
				request.setAttribute("fotopelicula",almpeli.getFotopelicula());
				
				//redireccionar 
				request.getRequestDispatcher("/FrmActualizarPelicula.jsp").forward(request, response);
				break;
			case "Actualizar":
			    int idpeli = Integer.parseInt(request.getParameter("idpelicula"));
			    String nombre = request.getParameter("nompelicula");

			    // Obtener la imagen actual
			    String imagenActual = p.BuscarRuta(idpeli); // Debes implementar este método

			    Part part = request.getPart("fotopelicula");

			    if (part != null && isExtension(part.getSubmittedFileName(), extens)) {
			        // Si se proporciona un nuevo archivo, procesarlo
			        String nuevaImagen = saveFile(part, uploads, nombre);

			        // Actualizar la película con la nueva imagen
			        ClassPelicula almpel = new ClassPelicula();
			        almpel.setIdpelicula(idpeli);
			        almpel.setNompelicula(nombre);
			        almpel.setFotopelicula(nuevaImagen);
			        p.ActualizarPelicula(almpel);
			    } else {
			        // Si no se proporciona un nuevo archivo, actualizar solo el nombre
			        ClassPelicula almpel = new ClassPelicula();
			        almpel.setIdpelicula(idpeli);
			        almpel.setNompelicula(nombre);
			        almpel.setFotopelicula(imagenActual); // Mantener la imagen actual
			        p.ActualizarPelicula(almpel);
			    }

			    response.sendRedirect("ControladorPelicula?action=Listar");
			    break;

			case "Buscar":
				PeliculaImp busquedad= new PeliculaImp();
				String buscar=request.getParameter("txtbuscar");
				List<ClassPelicula>busca = busquedad.BuscarTabla(buscar);
				request.setAttribute("ListadoPeliculas",busca);
				request.getRequestDispatcher("/ListadoPelicula.jsp").forward(request,response);
				break;
			case "Eliminar":
				
				//recuperamos el codigo..
				int cod= Integer.parseInt(request.getParameter("idpelicula"));
				//instanciamos las respectivas clases..
				ClassPelicula codeli = new ClassPelicula();
				PeliculaImp crudeli = new PeliculaImp();
				
				//asignamos el codigo a eliminar ..
				codeli.setIdpelicula(cod);
				//invocamos el metodo eliminar..
				crudeli.EliminarPelicula(codeli);
				
				
				//actualizamos nuestro listado
				List<ClassPelicula> listado= crudeli.ListarPelicula();
				//enviamos a la vista
				request.setAttribute("ListadoPeliculas",listado);
				//redireccionamos..
				request.getRequestDispatcher("ControladorPelicula?action=Listar").forward(request,response);
				
				break;	
			case "ListadoPelicula":
			    PeliculaImp listp = new PeliculaImp();
			    EmpleadoImp listemp = new EmpleadoImp();
			    // Obtener el nuevo número de boleta
			    BoletaImp crudbol = new BoletaImp();
			    String nuevoCodigoBoleta = crudbol.generarNumeroBoleta();
			    
			    // Actualizar el combobox del formulario registrar lote almacenando con datos de productos el select
			    List<ClassPelicula> listpebol = listp.ListarPelicula();
			    
			    List<Classempleado> listempbol = listemp.listarEmpleado();
			    // Enviar el nuevo número de boleta a la vista
			    request.setAttribute("nuevoCodigoBoleta", nuevoCodigoBoleta);
			    
			    // Enviar el listado de películas a la vista
			    request.setAttribute("ListadoPeliculas", listpebol);
			    request.setAttribute("ListadoEmpleados", listempbol);
			    // Redireccionar a la vista
			    request.getRequestDispatcher("/FrmRegistrarBoleta.jsp").forward(request, response);
			    break;

		}
		
			
		
	}
	
	private void savePelicula(HttpServletRequest req, HttpServletResponse res) throws IOException {
	    try {
	        String name = req.getParameter("nompelicula");
	        Part part = req.getPart("fotopelicula");
	        if (part == null) {
	            System.out.println("No ha seleccionado un archivo");
	            return;
	        }

	        if (isExtension(part.getSubmittedFileName(), extens)) {
	            String fotopelicula = saveFile(part, uploads, name);
	            ClassPelicula clpel = new ClassPelicula(name, fotopelicula);
	            p.RegistrarPelicula(clpel);
	        }

	        List<ClassPelicula> ListadoPeliculas = p.ListarPelicula();
	        req.setAttribute("ListadoPeliculas", ListadoPeliculas);
	        
	        
	        res.sendRedirect(req.getContextPath() + "/ControladorPelicula?action=Listar");
	        
	        
	        
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}

	private String saveFile(Part part, File pathUploads, String formName) {
	    String fileName = formName + ".jpg"; // Reemplaza ".jpg" con la extensión que deseas utilizar
	    try {
	        InputStream input = part.getInputStream();

	        if (input != null) {
	            File file = new File(pathUploads, fileName);
	            Files.copy(input, file.toPath());
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return fileName; // Devuelve solo el nombre del archivo, no la URL completa
	}

	private boolean isExtension(String fileName, String[] extensions) {
	    for (String et : extensions) {
	        if (fileName.toLowerCase().endsWith(et)) {
	            return true;
	        }
	    }
	    return false;
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
