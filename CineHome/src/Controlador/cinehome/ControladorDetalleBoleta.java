package Controlador.cinehome;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Conectar.Cinehome.ConectarBD;
import Dao.cinehome.DetalleBoletaImp;
import Dao.cinehome.EmpleadoImp;
import Modelo.ClassDetalleBoleta;
import Modelo.Classempleado;

/**
 * Servlet implementation class ControladorDetalleBoleta
 */
@WebServlet("/ControladorDetalleBoleta")
public class ControladorDetalleBoleta extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControladorDetalleBoleta() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String accion=request.getParameter("accion");
		//aplicamos una condicion...
		if(accion!=null){
			switch(accion){
			case "Listado":
				EmpleadoImp list= new EmpleadoImp();
				DetalleBoletaImp listemp = new DetalleBoletaImp();
				//actualizamos el combobox
				
				List<Classempleado> listadoemp = list.listarEmpleado();
				List<ClassDetalleBoleta> listaempbol=listemp.ListarcodEmp();
				//enviamos a la vista
				request.setAttribute("listadoEmpleado",listadoemp);
				//redireccionamos..
				request.getRequestDispatcher("/ConsultaDetalleBoleta.jsp").forward(request, response);
				break;
				
			}
		}
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
// Obtener el código de empleado del formulario
		
        String codigoEmpleado = request.getParameter("codigoemp");
        EmpleadoImp list= new EmpleadoImp();
        //DetalleBoletaImp listemp = new DetalleBoletaImp();
		//actualizamos el combobox
		
		//List<ClassDetalleBoleta> listaempbol=listemp.ListarcodEmp();
		List<Classempleado> listadoemp = list.listarEmpleado();

        // Llamar al método consulta para obtener los detalles de la boleta
        DetalleBoletaImp boletaDAO = new DetalleBoletaImp(); // Reemplaza con la clase adecuada
        List<ClassDetalleBoleta> detalleBoletaList = boletaDAO.consulta(codigoEmpleado);

        // Guardar los resultados en el objeto request
        request.setAttribute("listadoDetalleBoleta", detalleBoletaList);
      //enviamos a la vista
        request.setAttribute("listadoEmpleado",listadoemp);
      		
        // Redireccionar a la página JSP que muestra la tabla
        request.getRequestDispatcher("/ConsultaDetalleBoleta.jsp").forward(request, response);
        
   
    }


}
