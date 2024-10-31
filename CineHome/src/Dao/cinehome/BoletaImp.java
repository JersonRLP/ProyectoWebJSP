package Dao.cinehome;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import Conectar.Cinehome.ConectarBD;
import Interfaces.IntBoletaImp;
import Modelo.ClassBoleta;

public class BoletaImp implements IntBoletaImp{

	@Override
	public void RegistrarBoleta(ClassBoleta bol) {
		//instanciamos la clase conectar..
		ConectarBD conex= new ConectarBD();
		
		//realizamos la cadena o invocamos al procedimiento almacenado
		String sql="{call AddBoleta(?,?,?,?,?,?)}";
		//aplicamos la interface callablestatement....
		CallableStatement cs=null;
		//asignamos a la conexion y el p.a.
		
			try {
				cs=conex.ConexionMysql().prepareCall(sql);
				//asignamos parametros..
				cs.setString(1,bol.getCodboleta());
				cs.setString(2,bol.getCliente());
				cs.setInt(3,bol.getCantentra());
				cs.setInt(4,bol.getIdpelicula());
				cs.setString(5,bol.getNroasientos());
				cs.setDouble(6,bol.getPreciotot());
				//ejecutamos
				int x=cs.executeUpdate();
				//aplicamos...
				if(x>0){
					//emitimos un mensaje por consola
					System.out.println("Boleta Registrado en la BD EXITOSAMENTE");
				}
				else{
					System.out.println("Boleta No Registrado en la BD");
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

	@Override
	public void RegistrarDetalleBoleta(ClassBoleta bol) {
		//instanciamos la clase conectar..
		ConectarBD conex= new ConectarBD();
		
		//realizamos la cadena o invocamos al procedimiento almacenado
		String sql="{call AddDetalleboleta(?,?,?,?)}";
		//aplicamos la interface callablestatement....
		CallableStatement cs=null;
		//asignamos a la conexion y el p.a.
		
			try {
				cs=conex.ConexionMysql().prepareCall(sql);
				//asignamos parametros..
				cs.setString(1,bol.getCodboleta());
				cs.setString(2,bol.getCodigoemp());
				cs.setInt(3,bol.getCantentra());	
				cs.setDouble(4,bol.getPreciotot());
				//ejecutamos
				int x=cs.executeUpdate();
				//aplicamos...
				if(x>0){
					//emitimos un mensaje por consola
					System.out.println("DetalleBoleta Registrado en la BD EXITOSAMENTE");
				}
				else{
					System.out.println("DetalleBoleta No Registrado en la BD");
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
	}

	@Override
	public String generarNumeroBoleta() {
	    ConectarBD conex = new ConectarBD();
	    String nuevoCodigo = null;

	    String sql = "{CALL GenerarNumeroBoleta()}";
	    try (Connection connection = conex.ConexionMysql();
	         CallableStatement cs = connection.prepareCall(sql);
	         ResultSet rs = cs.executeQuery()) {

	        if (rs.next()) {
	            nuevoCodigo = rs.getString(1);  // Supongo que la columna devuelta es la primera
	        }
	    } catch (SQLException e) {
	        // Manejar la excepción adecuadamente (por ejemplo, regístrala o lánzala nuevamente)
	        e.printStackTrace();
	    }
	    return nuevoCodigo;
	}


	
	public String BuscarRuta(int idPelicula) {
	    //instanciamos la clase conectar..
	    ConectarBD conex = new ConectarBD();
	    //realizamos la cadena o invocamos al prodecimiento almacenado
	    String sql = "{call BuscarRuta(?)}";
	    //aplicamos la respectiva interface..
	    CallableStatement cs = null;
	    ResultSet rs = null;
	    String rutaImagen = null;

	    try {
	        cs = conex.ConexionMysql().prepareCall(sql);
	        //asignamos el parametro
	        cs.setInt(1, idPelicula);
	        rs = cs.executeQuery();
	        //aplicamos una condicion 
	        if (rs.next()) {
	            rutaImagen = rs.getString("fotopelicula"); // Reemplaza "ruta_imagen" con el nombre real de la columna en tu base de datos
	        }
	    } catch (SQLException e) {
	        // Maneja la excepción adecuadamente (por ejemplo, regístrala o lánzala nuevamente)
	        e.printStackTrace();
	    } finally {
	        // Cerrar recursos (ResultSet, Statement, Connection) aquí si es necesario
	        // Debes manejar adecuadamente la conexión y los recursos para evitar posibles fugas de memoria.
	    }
	    return rutaImagen;
	}
}
