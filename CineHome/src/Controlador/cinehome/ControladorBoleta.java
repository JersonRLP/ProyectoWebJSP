package Controlador.cinehome;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.StringReader;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.html.simpleparser.HTMLWorker;
import com.itextpdf.text.pdf.PdfWriter;


import Dao.cinehome.BoletaImp;
import Modelo.ClassBoleta;

/**
 * Servlet implementation class ControladorBoleta
 */
@WebServlet("/ControladorBoleta")
public class ControladorBoleta extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControladorBoleta() {
        super();
        // TODO Auto-generated constructor stub
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
		//recuperamos los valores del formulario...
		String[] opcionproduc=request.getParameterValues("idpelicula");
		int idpeli= Integer.parseInt(opcionproduc[0]);
		
		// Obtener el nombre de la película seleccionada
		String nombrePelicula = request.getParameter("nombrePelicula");

		
		String codboleta= request.getParameter("codboleta");
		String cliente= request.getParameter("cliente");
		int cantentra= Integer.parseInt(request.getParameter("cantentra"));
		String nroasientos= request.getParameter("nroasientos");
		double preciotot=Double.parseDouble(request.getParameter("preciotot"));
		String codigoemp=request.getParameter("codigoemp");
		//realizamos las respectivas instancias
		ClassBoleta clbol=new  ClassBoleta();
		BoletaImp crudbol= new BoletaImp();
		//realizamos la respectiva asignaciones..
		clbol.setCodboleta(codboleta);
		clbol.setCliente(cliente);
		clbol.setCantentra(cantentra);
		clbol.setIdpelicula(idpeli);
		clbol.setNroasientos(nroasientos);
		clbol.setPreciotot(preciotot);
		//asignamos lo de detalle de boleta
		clbol.setCodigoemp(codigoemp);
		//invocamos al metodo registrar 
		crudbol.RegistrarBoleta(clbol);
		crudbol.RegistrarDetalleBoleta(clbol);
		
	
			
			Document documentPdf = new Document();
			try {
			    response.setContentType("application/pdf");
			    response.setHeader("Content-Disposition", "attachment; filename=boleta.pdf");

			    PdfWriter.getInstance(documentPdf, response.getOutputStream());
			    documentPdf.open();
			    
			    
		
		
		HTMLWorker htmlworker = new HTMLWorker(documentPdf);
		// Obtener la fecha actual
        Date fechaActual = new Date();

        // Definir un formato para la fecha
        SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");

        // Formatear la fecha como una cadena
        String fechaFormateada = formato.format(fechaActual);
        
        // Obtener la hora actual
        LocalTime horaActual = LocalTime.now();

        // Definir un formato para la hora
        DateTimeFormatter formato1 = DateTimeFormatter.ofPattern("HH:mm:ss");

        // Formatear la hora como una cadena
        String horaFormateada = horaActual.format(formato1);
        
		String str = "<html><head></head><body>"+
				"<br>" +
				"<img align='center' src='http://localhost/files/anime.jpg' width='200' height='200'>" +
				"<h1 align='center'>Boleta de Compra de Entradas</h1>"+
				"<br>" +
				"<p align='center'>Película: "+ nombrePelicula +"</p>"+
				"<br>" +
				"<p align='center'>Fecha:" +fechaFormateada + "</p>"+
				"<br>" +
				"<p align='center'>Hora: " +horaFormateada + "</p>"+
				"<br>" +
				"<p align='center'>Cantidad de Entradas: "+ nroasientos+ "</p>"+
				"<br>" +
				"<p align='center'>Precio Total:"+ preciotot+  "</p>" +
				
				"</body>" +
				"</html>"
				
				;
				
        
        		htmlworker.parse(new StringReader(str));
	    // No redirigir a ninguna página

	   documentPdf.close();
			} catch (DocumentException e) {
			    e.printStackTrace();
			}
	   
	}

}
