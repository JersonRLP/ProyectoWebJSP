package Dao.cinehome;


import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import Conectar.Cinehome.ConectarBD;
import Interfaces.IntPeliculaImp;
import Modelo.ClassPelicula;


public class PeliculaImp implements IntPeliculaImp{

	@Override
	public void RegistrarPelicula(ClassPelicula clpel) {
		//instanciamos la clase conectar..
				ConectarBD conex=new ConectarBD();
				//realizamos la cadena....
				String sql="insert into Pelicula values(null,?,?)";
				//declaramos la interfaces predeterminadas para base de datos
				PreparedStatement ps=null;
				//asignar la conexion y la cadena a la variable ps
				try {
					ps=conex.ConexionMysql().prepareStatement(sql);
					//asignamos los valores recuperados puestos por el usuario
					ps.setString(1,clpel.getNompelicula());
					ps.setString(2,clpel.getFotopelicula());
					
					
					//ejecutamos
					int x=ps.executeUpdate();
					//aplicamos una condicion
					if(x>0){
						//emitimos un mensaje por consola
						System.out.println("Pelicula Registrado en la BD");
					} else{
						//emitimos un mensaje por consola
						System.out.println("Pelicula NO Registrado en la BD");
						
					}	
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
	}

	@Override
	public void ActualizarPelicula(ClassPelicula clpel) {
		//instanciamos la clase ConectarBD
				ConectarBD conex = new ConectarBD();
				//invocamos el procedimiento almacenado mediante una variable ...
				String sql ="{call updatePelicula(?,?,?)}";
				//aplicamos la interface callableStatament
				
				CallableStatement cs=null;
				//asignamos a la conexion el procedimiento almacenado 
				
				try {
					cs=conex.ConexionMysql().prepareCall(sql);
					//asignamos los parametros al p .a
					cs.setInt(1,clpel.getIdpelicula());
					cs.setString(2,clpel.getNompelicula());
					cs.setString(3,clpel.getFotopelicula());
					
					//ejecutamos y mandamos el numero de parametros a X que en este caso es 5 ;
					int x =cs.executeUpdate();
					//aplicamos una condicion
					if(x>0){
						//emitimos un mensaje por consola
						System.out.println("Pelicula se ACTUALIZADO en la BD EXITOSAMENTE");
					}
					else{
						System.out.println("ERROR al Actualizar Pelicula en la BD");
					}
					
					
				} catch (SQLException e) {
					e.printStackTrace();
				}
		
	}

	@Override
	public void EliminarPelicula(ClassPelicula clpel) {
		//instanciamos la clase conectar..
				ConectarBD conex=new ConectarBD();
				//realizamos la cadena o invocamos al prodecimiento almacenado
				String sql="{call deletePelicula(?)}";
				//aplicamos la respectiva interface..
				CallableStatement cs=null;
				try {
					cs=conex.ConexionMysql().prepareCall(sql);
					//asignamos los parametros
					cs.setInt(1,clpel.getIdpelicula());
					
					//realizamos la ejecucion..
					int z=cs.executeUpdate();
					//aplicamos una condicion
					if(z>0){
						//emitimos un mensaje por pantalla
						System.out.println("Pelicula Eliminado Correctamente");
						
					}
					else{
						//emitimos un mensaje por pantalla
						System.out.println("Error Al Eliminar");
					}
					
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	}

	@Override
	public List<ClassPelicula> ListarPelicula() {
		//instanciamos la clase conectar BD...
				ConectarBD conex=new ConectarBD();
				//realizamos la respectiva cadena en mysql
				String sql="select * from Pelicula";
				//aplicamos las interfaces para base de datos
				PreparedStatement ps=null;
				ResultSet rs=null;
				List<ClassPelicula> listado=new ArrayList<>();
				//realizamos la respectiva asignacion de conexion y cadena..
				try {
					ps=conex.ConexionMysql().prepareStatement(sql);
					//realizamos la ejecucion
					rs=ps.executeQuery();
					//aplicamos una condicion
					while(rs.next()){
						//instanciamos la clase classusuario para almacenar datos de la BD..
					ClassPelicula clpel=new ClassPelicula();
					clpel.setIdpelicula(rs.getInt(1));
					clpel.setNompelicula(rs.getString(2));
					clpel.setFotopelicula(rs.getString(3));
					
				    listado.add(clpel);
					}  //fin del bucle...		
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}	
				//retornamos la data (listado de productos)
				return listado;
	}

	@Override
	public ClassPelicula BuscarPelicula(ClassPelicula clpel) {
		//instanciamos la clase conectar..
		ConectarBD conex=new ConectarBD();
		//realizamos la cadena o invocamos al prodecimiento almacenado
		String sql="{call BuscaridPelicula(?)}";
		//aplicamos la respectiva interface..
		CallableStatement cs=null;
		ResultSet rs=null;
		//instanciamos la respetiva clase 
		//para almacenar el codpel recuperado
		ClassPelicula almpeli= new ClassPelicula();
		try {
			cs=conex.ConexionMysql().prepareCall(sql);
			//asignamos el parametro
			cs.setInt(1,clpel.getIdpelicula());
			rs=cs.executeQuery();
			//aplicamos una condicion 
			if(rs.next()){
				
				almpeli.setIdpelicula(rs.getInt(1));
				almpeli.setNompelicula(rs.getString(2));
				almpeli.setFotopelicula(rs.getString(3));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return almpeli;
	}

	@Override
	public List<ClassPelicula> BuscarTabla(String buscar) {
		//instanciamos la clase conectar BD...
		ConectarBD conex=new ConectarBD();
		//realizamos la respectiva cadena en mysql
		String sql="{call BuscarlistPeli(?)}";
		//aplicamos las interfaces para base de datos
		CallableStatement cs=null;
		ResultSet rs=null;
		
		List<ClassPelicula> listado=new ArrayList<>();
		
		
		try {
			cs=conex.ConexionMysql().prepareCall(sql);
			cs.setString(1,buscar);
			rs=cs.executeQuery();
			
			while(rs.next()){
				//instanciamos la clase classusuario para almacenar datos de la BD..
			ClassPelicula clusu=new ClassPelicula();
			clusu.setIdpelicula(rs.getInt(1));
			clusu.setNompelicula(rs.getString(2));
			clusu.setFotopelicula(rs.getString(3));
		
		    listado.add(clusu);
		    }//fin del bucle
		
		}
			catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//realizamos la ejecucion
		
			return listado;
	}

	@Override
	public ClassPelicula buscaNompeli(ClassPelicula clpel) {
		//instanciamos la clase conectar..
		ConectarBD conex=new ConectarBD();
		//realizamos la cadena o invocamos al prodecimiento almacenado
		String sql="{call buscaNompeli(?)}";
		//aplicamos la respectiva interface..
		CallableStatement cs=null;
		ResultSet rs=null;
		//instanciamos la respetiva clase 
		//para almacenar el lote recuperado
		ClassPelicula almpeli= new ClassPelicula();
		try {
			cs=conex.ConexionMysql().prepareCall(sql);
			//asignamos el parametro
			cs.setInt(1,clpel.getIdpelicula());
			rs=cs.executeQuery();
			//aplicamos una condicion 
			if(rs.next()){
				
				almpeli.setIdpelicula(rs.getInt(1));
				almpeli.setNompelicula(rs.getString(2));
				almpeli.setFotopelicula(rs.getString(3));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return almpeli;
	}

	@Override
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
