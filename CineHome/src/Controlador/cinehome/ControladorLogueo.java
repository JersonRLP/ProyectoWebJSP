package Controlador.cinehome;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.cinehome.EmpleadoImp;
import Dao.cinehome.UsuarioImp;
import Modelo.ClassUsuario;
import Modelo.Classempleado;

/**
 * Servlet implementation class ControladorLogueo
 */
@WebServlet("/ControladorLogueo")
public class ControladorLogueo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControladorLogueo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//emitimos un mensaje por el navegador
		
				PrintWriter out=response.getWriter();
				
				//declaramos una variable para el mensaje
				String mensaje="";
				//declaramos variable para redireccionar...
				String url="";
				
				//recuperamos los valores del formulario...
				String usuario=request.getParameter("usuario");
				String password=request.getParameter("password");
				
				//instanciamos la clase de nombre classusuario...
				ClassUsuario clusu=new ClassUsuario();
				//asignamos los valores que vienen del formulario
				//a los metodos setter 
				
				clusu.setUsuario(usuario);
				clusu.setPassword(password);
				
				//instanciamos la clase usuarioimpl
				UsuarioImp valusu=new UsuarioImp();
				//recuperamos los valores que vienen de la BD..
				//invocamos al metodo validar usuario
				ClassUsuario veriusu=valusu.ValidarUsuario(clusu);
				
			
				if(veriusu.getUsuario()!=null && veriusu.getPassword()!=null){
					mensaje="Credenciales Correctas BIENVENIDO desde un servlet";
					//redireccionamos
					url="/MenuPrincipal.jsp";		
				}else{		
					mensaje="Credenciales Incorrectas desde un servlet";
					url="index.jsp";
				}   //fin del else...
				
					
				// salidas hacia los archivos JSP...
				
				request.setAttribute("mensaje",mensaje);
				
				//realizamos la respectivo redireccionamiento
				request.getRequestDispatcher(url).forward(request, response);
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
		doGet(request, response);
	}

}
