package Controlador.cinehome;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

/**
 * Servlet implementation class Generarqrboleta
 */
@WebServlet("/Generarqrboleta")
public class Generarqrboleta extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Generarqrboleta() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Informacion de la boleta convertida en codigoQR
				String nombrePelicula = request.getParameter("nombrePelicula");

				
				String codboleta= request.getParameter("codboleta");
				String cliente= request.getParameter("cliente");
				int cantentra= Integer.parseInt(request.getParameter("cantentra"));
				int nroasientos= Integer.parseInt(request.getParameter("nroasientos"));
				double preciotot=Double.parseDouble(request.getParameter("preciotot"));
				
				
				
				//crear una variable que concatene toda la informacion 
				String infoboletaQr =codboleta +"\n" + nombrePelicula + "\n"+ cliente + "\n" + cantentra+"\n" + nroasientos+"\n"+preciotot;
		
				response.setContentType("image/png");
				OutputStream outputStream = response.getOutputStream();
				outputStream.write(getQRCodeImage(infoboletaQr,400,400));
				outputStream.flush();
				outputStream.close();
	}

	
	private byte[] getQRCodeImage(String text,int width,int height){
		try {
			QRCodeWriter qrCodeWriter = new QRCodeWriter();
			BitMatrix bitMatrix = qrCodeWriter.encode(text,BarcodeFormat.QR_CODE, width, height);
			ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
			MatrixToImageWriter.writeToStream(bitMatrix, "png",byteArrayOutputStream);
			return byteArrayOutputStream.toByteArray();
		} catch (Exception e) {
			return null;
		}
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
