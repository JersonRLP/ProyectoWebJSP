package Dao.cinehome;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Conectar.Cinehome.ConectarBD;
import Interfaces.IntUsuario;
import Modelo.ClassUsuario;
import Modelo.Classempleado;

public class UsuarioImp implements IntUsuario{

	@Override
	public void RegistrarUsuario(ClassUsuario clusu) {
		//instanciamos la clase conectar..
		ConectarBD conex= new ConectarBD();
		
		//realizamos la cadena o invocamos al procedimiento almacenado
		String sql="{call AddUsuario(?,?,?)}";
		//aplicamos la interface callablestatement....
		CallableStatement cs=null;
		//asignamos a la conexion y el p.a.
		
			try {
				cs=conex.ConexionMysql().prepareCall(sql);
				//asignamos parametros..
				cs.setString(1,clusu.getCodigoemp());
				cs.setString(2,clusu.getUsuario());
				cs.setString(3,clusu.getPassword());
				
				//ejecutamos
				int x=cs.executeUpdate();
				//aplicamos...
				if(x>0){
					//emitimos un mensaje por consola
					System.out.println("Usuario Registrado en la BD EXITOSAMENTE");
				}
				else{
					System.out.println("Usuario No Registrado en la BD");
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}// fin del metodo registrar usuario

	@Override
	public void ActualizarUsuario(ClassUsuario clusu) {
		//instanciamos la clase conectar..
				ConectarBD conex= new ConectarBD();
				
				//realizamos la cadena o invocamos al procedimiento almacenado
				String sql="{call updateUsuario(?,?,?)}";
				//aplicamos la interface callablestatement....
				CallableStatement cs=null;
				//asignamos a la conexion y el p.a.
				
					try {
						cs=conex.ConexionMysql().prepareCall(sql);
						//asignamos parametros..
						cs.setString(1,clusu.getCodigoemp());
						cs.setString(2,clusu.getUsuario());
						cs.setString(3,clusu.getPassword());
						
						//ejecutamos
						int x=cs.executeUpdate();
						//aplicamos...
						if(x>0){
							//emitimos un mensaje por consola
							System.out.println("Usuario Actualizado en la BD EXITOSAMENTE");
						}
						else{
							System.out.println("Usuario No Actualizado en la BD");
						}
						
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	}

	@Override
	public void EliminarUsuario(ClassUsuario clusu) {
		//instanciamos la clase conectar..
				ConectarBD conex=new ConectarBD();
				//realizamos la cadena o invocamos al prodecimiento almacenado
				String sql="{call EliminarUsuario(?)}";
				//aplicamos la respectiva interface..
				CallableStatement cs=null;
				try {
					cs=conex.ConexionMysql().prepareCall(sql);
					//asignamos los parametros
					cs.setString(1,clusu.getCodigoemp());
					
					//realizamos la ejecucion..
					int z=cs.executeUpdate();
					//aplicamos una condicion
					if(z>0){
						//emitimos un mensaje por pantalla
						System.out.println("Usuario Eliminado Correctamente");
						
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
	public List<ClassUsuario> ListadoUsuario() {
		//instanciamos la clase conectar BD...
				ConectarBD conex=new ConectarBD();
				//realizamos la respectiva cadena en mysql
				String sql="call listUsuario";
				//aplicamos las interfaces para base de datos
				PreparedStatement ps=null;
				ResultSet rs=null;
				
				List<ClassUsuario> listado=new ArrayList<>();
				
				
				try {
					ps=conex.ConexionMysql().prepareStatement(sql);
					rs=ps.executeQuery();
					
					while(rs.next()){
						//instanciamos la clase classusuario para almacenar datos de la BD..
					ClassUsuario clusu=new ClassUsuario();
					clusu.setCodigoemp(rs.getString(1));
					clusu.setUsuario(rs.getString(2));
					clusu.setPassword(rs.getString(3));
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
	public List<ClassUsuario> BuscarUsuario(String buscar) {
		//instanciamos la clase conectar BD...
				ConectarBD conex=new ConectarBD();
				//realizamos la respectiva cadena en mysql
				String sql="{call BuscarUsuario(?)}";
				//aplicamos las interfaces para base de datos
				CallableStatement cs=null;
				ResultSet rs=null;
				
				List<ClassUsuario> listado=new ArrayList<>();
				
				
				try {
					cs=conex.ConexionMysql().prepareCall(sql);
					cs.setString(1,buscar);
					rs=cs.executeQuery();
					
					while(rs.next()){
						//instanciamos la clase classusuario para almacenar datos de la BD..
					ClassUsuario clusu=new ClassUsuario();
					clusu.setCodigoemp(rs.getString(1));
					clusu.setUsuario(rs.getString(2));
					clusu.setPassword(rs.getString(3));
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
	public ClassUsuario ValidarUsuario(ClassUsuario clusu) {
		//instanciar la conexion a la base de datos...
				ConectarBD conex=new ConectarBD();
				//realizamos la respectiva cadena...
				String sql="select * from usuario where usuario=? and password=?";
				//aplicar las interfaces predeterminadas para base de datos
				PreparedStatement ps=null;
				ResultSet rs=null;
				
				//hace una instancia de la classusuario...
				ClassUsuario clalm=new ClassUsuario();
				
				//asignar valores como la conexion y cadena...
				try {
					ps=conex.ConexionMysql().prepareStatement(sql);
					//asignamos los parametros...
					ps.setString(1,clusu.getUsuario());
					ps.setString(2,clusu.getPassword());
					//ejecutamos
					rs=ps.executeQuery();
					//aplicamos una condicion..
					if(rs.next()){
						//recuperamos los valores que vienen de la BD....
						clalm.setUsuario(rs.getString(1));
						clalm.setPassword(rs.getString(2));	
					}   //fin de la condicion..
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				//retornamos los respectivos valores...
				return clalm;
	}

	@Override
	public ClassUsuario BuscarDatosUsuario(ClassUsuario clusu) {
		//instanciamos la clase conectar..
		ConectarBD conex=new ConectarBD();
		//realizamos la cadena o invocamos al prodecimiento almacenado
		String sql="{call BuscarDatosUsuario(?)}";
		//aplicamos la respectiva interface..
		CallableStatement cs=null;
		ResultSet rs=null;
		//instanciamos la respetiva clase 
		//para almacenar el lote recuperado
		ClassUsuario almusu= new ClassUsuario();
		try {
			cs=conex.ConexionMysql().prepareCall(sql);
			//asignamos el parametro
			cs.setString(1,clusu.getCodigoemp());
			rs=cs.executeQuery();
			//aplicamos una condicion 
			if(rs.next()){
				
				almusu.setCodigoemp(rs.getString(1));
				almusu.setUsuario(rs.getString(2));
				almusu.setPassword(rs.getString(3));
			
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return almusu;
	}

	@Override
	public ClassUsuario ValidacodUsu(ClassUsuario clusu) {
		//instanciamos la clase conectar..
		ConectarBD conex=new ConectarBD();
		//realizamos la cadena o invocamos al prodecimiento almacenado
		String sql="{call ValidacodUsu(?)}";
		//aplicamos la respectiva interface..
		CallableStatement cs=null;
		ResultSet rs=null;
		//instanciamos la respetiva clase 
		//para almacenar el lote recuperado
		ClassUsuario almusu= new ClassUsuario();
		try {
			cs=conex.ConexionMysql().prepareCall(sql);
			//asignamos el parametro
			cs.setString(1,clusu.getCodigoemp());
			rs=cs.executeQuery();
			//aplicamos una condicion 
			if(rs.next()){
				
				almusu.setCodigoemp(rs.getString(1));
				almusu.setUsuario(rs.getString(2));
				almusu.setPassword(rs.getString(3));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return almusu;
	}

}
