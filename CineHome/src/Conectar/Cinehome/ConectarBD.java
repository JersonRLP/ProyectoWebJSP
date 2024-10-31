package Conectar.Cinehome;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class ConectarBD {

	//declaramos variables de tipo cadena y asignamos valores
	String url="jdbc:mysql://localhost:3306/cinehome";
	String usuario="root";
	String password="";
	Connection con;
	//creamos el metodo
	public Connection ConexionMysql(){
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			//clase para conectar con la BD...
			con=DriverManager.getConnection(url, usuario, password);
			
			//emitimos un mensaje de confirmacion que se conecto con la BD...
			//utilizamos una condicion..
			if(con!=null) 
				System.out.println("Conectado Correctamente a la base de datos");
				//JOptionPane.showMessageDialog(null,"conexion EXITOSA con BD",
				//	"MENSAJE",JOptionPane.INFORMATION_MESSAGE);
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		//retornamos la conexion
		return con;
		
	} 
	
}
