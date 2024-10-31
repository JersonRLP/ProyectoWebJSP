package Controlador.cinehome;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.cinehome.EmpleadoImp;
import Dao.cinehome.PeliculaImp;
import Modelo.ClassPelicula;
import Modelo.Classempleado;

/**
 * Servlet implementation class ControladorEmpleado
 */
@WebServlet("/ControladorEmpleado")
public class ControladorEmpleado extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControladorEmpleado() {
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
						
						EmpleadoImp list = new EmpleadoImp();
						//actualizamos nuestro listado
						List<Classempleado> listadoEmpleado= list.listarEmpleado();
						//enviamos a la vista
						request.setAttribute("listadoEmpleado",listadoEmpleado);
						//redireccionamos..
						request.getRequestDispatcher("/ListadoEmpleados.jsp").forward(request,response);
						break;
					case "Buscar":
						EmpleadoImp busquedad= new EmpleadoImp();
						String buscar=request.getParameter("txtbuscar");
						List<Classempleado>busca = busquedad.BuscarTabla(buscar);
						request.setAttribute("listadoEmpleado",busca);
						request.getRequestDispatcher("/ListadoEmpleados.jsp").forward(request,response);
						break;
						
					case "Modificar":
						String codigoemp = request.getParameter("codigoemp");
						//iniciamos las respectivas clases 
						Classempleado clemp= new Classempleado();
						EmpleadoImp crudemp = new EmpleadoImp();
						//inicializamos el codigo buscar 
						clemp.setCodigoemp(codigoemp);
						Classempleado alemp = crudemp.BuscarEmpleado(clemp);
						//enviamos al formulario los datos 
						request.setAttribute("codigoemp",alemp.getCodigoemp());
						request.setAttribute("nomemp",alemp.getNomemp());
						request.setAttribute("distrito",alemp.getDistrito());
						request.setAttribute("numero",alemp.getNumero());
						request.setAttribute("correo",alemp.getCorreo());
						request.setAttribute("cargo",alemp.getCargo());
						//redireccionar 
						request.getRequestDispatcher("/FrmActualizarEmpleado.jsp").forward(request, response);
						break;
					case "Eliminar":
						//recuperamos el codigo..
						String cod=request.getParameter("codigoemp");
						//instanciamos las respectivas clases..
						Classempleado clempeli = new Classempleado();
						EmpleadoImp empeli = new EmpleadoImp();
						//asignamos el codigo a eliminar ..
						clempeli.setCodigoemp(cod);
						//invocamos el metodo eliminar..
						empeli.EliminarEmpleado(clempeli);
						//actualizamos nuestro listado
						List<Classempleado> listado= empeli.listarEmpleado();
						//enviamos a la vista
						request.setAttribute("listadoEmpleado",listado);
						//redireccionamos..
						request.getRequestDispatcher("/ListadoEmpleados.jsp").forward(request,response);
						
						break;
					case "ListadoEmp":					
						EmpleadoImp listemp = new EmpleadoImp();
						//actualizamos el combobox
						
						List<Classempleado> listaempbol=listemp.listarEmpleado();
						//enviamos a la vista
						request.setAttribute("listadoEmpleado",listaempbol);
						//redireccionamos..
						request.getRequestDispatcher("/ConsultaDetalleBoleta.jsp").forward(request, response);
						break;
						
					case "NuevoEmp":
						EmpleadoImp nuevocod = new EmpleadoImp();
						
						String newcodigo = nuevocod.GenerarCodigoEmp();
						
						request.setAttribute("newcodigo",newcodigo);
						
						request.getRequestDispatcher("/FrmRegistrarEmpleado.jsp").forward(request, response);
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
				String nomemp=request.getParameter("nomemp");
				String distrito=request.getParameter("distrito");
				int numero=Integer.parseInt(request.getParameter("numero"));
				String correo=request.getParameter("correo");
				String cargo=request.getParameter("cargo");
				//intanciamos las respectivas clases...
				Classempleado clemp = new Classempleado();
				EmpleadoImp crudemp = new EmpleadoImp();
				//asignamos los valores que recuperamos del formulario 
				clemp.setCodigoemp(codigoemp);
				clemp.setNomemp(nomemp);
				clemp.setDistrito(distrito);
				clemp.setNumero(numero);
				clemp.setCorreo(correo);
				clemp.setCargo(cargo);
				
				Classempleado valicodemp = crudemp.ValidarEmpleado(clemp);
				
				if(valicodemp.getCodigoemp()!=null){
				crudemp.ActualizarEmpleado(clemp);
				}
				else{
				crudemp.RegistrarEmpleado(clemp);	
				}
				List<Classempleado> ListadoEmpleado=crudemp.listarEmpleado();

				//enviamos a la vista

				request.setAttribute("listadoEmpleado",ListadoEmpleado);

				
				//redireccionar al listado de productos

				request.getRequestDispatcher("/ListadoEmpleados.jsp").forward(request,response);
	}

}
