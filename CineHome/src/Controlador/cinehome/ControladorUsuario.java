package Controlador.cinehome;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.cinehome.BoletaImp;
import Dao.cinehome.EmpleadoImp;
import Dao.cinehome.UsuarioImp;
import Modelo.ClassPelicula;
import Modelo.ClassUsuario;
import Modelo.Classempleado;

/**
 * Servlet implementation class ControladorUsuario
 */
@WebServlet("/ControladorUsuario")
public class ControladorUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControladorUsuario() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//recuperamos el codigo y la accion
		String accion=request.getParameter("accion");
		//aplicamos una condicion...
		if(accion!=null){
			switch(accion){
			case "Listado":
				 EmpleadoImp listemp = new EmpleadoImp();
	
			    List<Classempleado> listempbol = listemp.listarEmpleado();
				    request.setAttribute("ListadoEmpleados", listempbol);
				UsuarioImp list = new UsuarioImp();
				//actualizamos nuestro listado
				List<ClassUsuario> listadoUsuario= list.ListadoUsuario();
				//enviamos a la vista
				request.setAttribute("listadoUsuario",listadoUsuario);
				//redireccionamos..
				request.getRequestDispatcher("/FrmLogin.jsp").forward(request,response);
				break;
			case "Modificar":
				String codigoemp = request.getParameter("codigoemp");
				//iniciamos las respectivas clases 
				ClassUsuario clusu= new ClassUsuario();
				UsuarioImp crudusu = new UsuarioImp();
				//inicializamos el codigo buscar 
				clusu.setCodigoemp(codigoemp);
				ClassUsuario almusu = crudusu.BuscarDatosUsuario(clusu);
				//enviamos al formulario los datos 
				request.setAttribute("codigoemp",almusu.getCodigoemp());
				request.setAttribute("usuario",almusu.getUsuario());
				request.setAttribute("password",almusu.getPassword());
				
				//redireccionar 
				request.getRequestDispatcher("/FrmModalUsuario.jsp").forward(request, response);
				break;
			case "Eliminar":
				//recuperamos el codigo..
				String cod=request.getParameter("codigoemp");
				//instanciamos las respectivas clases..
				ClassUsuario clusueli = new ClassUsuario();
				UsuarioImp usueli = new UsuarioImp();
				//asignamos el codigo a eliminar ..
				clusueli.setCodigoemp(cod);
				//invocamos el metodo eliminar..
				usueli.EliminarUsuario(clusueli);
				//actualizamos nuestro listado
				List<ClassUsuario> listado= usueli.ListadoUsuario();
				//enviamos a la vista
				request.setAttribute("listadoUsuario",listado);
				//redireccionamos..
				request.getRequestDispatcher("/FrmLogin.jsp").forward(request,response);
				
				break;
			case "Buscar":
				UsuarioImp busquedad= new UsuarioImp();
				String buscar=request.getParameter("txtbuscar");
				List<ClassUsuario>busca = busquedad.BuscarUsuario(buscar);
				request.setAttribute("listadoUsuario",busca);
				request.getRequestDispatcher("/FrmLogin.jsp").forward(request,response);
				break;
			}
		}
		
	
		
	}
		
	
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			
			//recuperamos el codigo de formulario actualizar
			String codigoemp= request.getParameter("codigoemp");
			//recuperamos los datos del formulario registrar producto
			String usuario=request.getParameter("usuario");
			String password=request.getParameter("password");
			
			//intanciamos las respectivas clases...
			ClassUsuario clusu = new ClassUsuario();
			UsuarioImp crudusu = new UsuarioImp();
			//asignamos los valores que recuperamos del formulario 
			clusu.setCodigoemp(codigoemp);
			clusu.setUsuario(usuario);
			clusu.setPassword(password);
			
			ClassUsuario veriusu=crudusu.ValidacodUsu(clusu);
					
				
			if(veriusu.getCodigoemp()!=null){
			crudusu.ActualizarUsuario(clusu);
			}
			else{
			crudusu.RegistrarUsuario(clusu);	
			}
			
		
			List<ClassUsuario> ListadoUsuario=crudusu.ListadoUsuario();
	
			//enviamos a la vista
				EmpleadoImp listemp = new EmpleadoImp();
				
			    List<Classempleado> listempbol = listemp.listarEmpleado();
			    
				    request.setAttribute("ListadoEmpleados", listempbol);
			
				    request.setAttribute("listadoUsuario", ListadoUsuario);
			//redireccionar al listado de productos
	
			request.getRequestDispatcher("/FrmLogin.jsp").forward(request,response);
		}

}
