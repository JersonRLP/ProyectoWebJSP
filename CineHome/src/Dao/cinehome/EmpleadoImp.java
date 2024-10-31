package Dao.cinehome;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Conectar.Cinehome.ConectarBD;
import Interfaces.IntempleadoImp;
import Modelo.Classempleado;

public class EmpleadoImp implements IntempleadoImp{

	@Override
	public void RegistrarEmpleado(Classempleado clemp) {
		//instanciamos la clase conectar..
				ConectarBD conex= new ConectarBD();
				
				//realizamos la cadena o invocamos al procedimiento almacenado
				String sql="{call AddEmpleado(?,?,?,?,?,?)}";
				//aplicamos la interface callablestatement....
				CallableStatement cs=null;
				//asignamos a la conexion y el p.a.
				
					try {
						cs=conex.ConexionMysql().prepareCall(sql);
						//asignamos parametros..
						cs.setString(1,clemp.getCodigoemp());
						cs.setString(2,clemp.getNomemp());
						cs.setString(3,clemp.getDistrito());
						cs.setInt(4,clemp.getNumero());
						cs.setString(5,clemp.getCorreo());
						cs.setString(6,clemp.getCargo());
						//ejecutamos
						int x=cs.executeUpdate();
						//aplicamos...
						if(x>0){
							//emitimos un mensaje por consola
							System.out.println("Empleado Registrado en la BD EXITOSAMENTE");
						}
						else{
							System.out.println("Empleado No Registrado en la BD");
						}
						
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	}

	@Override
	public void ActualizarEmpleado(Classempleado clemp) {
		//instanciamos la clase ConectarBD
		ConectarBD conex = new ConectarBD();
		//invocamos el procedimiento almacenado mediante una variable ...
		String sql ="{call updateEmpleado(?,?,?,?,?,?)}";
		//aplicamos la interface callableStatament
		
		CallableStatement cs=null;
		//asignamos a la conexion el procedimiento almacenado 
		
		try {
			cs=conex.ConexionMysql().prepareCall(sql);
			//asignamos los parametros al p .a
			cs.setString(1,clemp.getCodigoemp());
			cs.setString(2,clemp.getNomemp());
			cs.setString(3,clemp.getDistrito());
			cs.setInt(4,clemp.getNumero());
			cs.setString(5,clemp.getCorreo());
			cs.setString(6,clemp.getCargo());
			//ejecutamos y mandamos el numero de parametros a X que en este caso es 5 ;
			int x =cs.executeUpdate();
			//aplicamos una condicion
			if(x>0){
				//emitimos un mensaje por consola
				System.out.println("Empleado Se Actualizado en la BD EXITOSAMENTE");
			}
			else{
				System.out.println("ERROR al Actualizar Empleado en la BD");
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void EliminarEmpleado(Classempleado clemp) {
		//instanciamos la clase conectar..
		ConectarBD conex=new ConectarBD();
		//realizamos la cadena o invocamos al prodecimiento almacenado
		String sql="{call deleteEmpleado(?)}";
		//aplicamos la respectiva interface..
		CallableStatement cs=null;
		try {
			cs=conex.ConexionMysql().prepareCall(sql);
			//asignamos los parametros
			cs.setString(1,clemp.getCodigoemp());
			
			//realizamos la ejecucion..
			int z=cs.executeUpdate();
			//aplicamos una condicion
			if(z>0){
				//emitimos un mensaje por pantalla
				System.out.println("Empleado Eliminado Correctamente");
				
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
	public List<Classempleado> listarEmpleado() {
		//instanciamos la clase conectar BD...
		ConectarBD conex=new ConectarBD();
		//realizamos la respectiva cadena en mysql
		String sql="call listEmpleado";
		//aplicamos las interfaces para base de datos
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		List<Classempleado> listado=new ArrayList<>();
		
		
		try {
			ps=conex.ConexionMysql().prepareStatement(sql);
			rs=ps.executeQuery();
			
			while(rs.next()){
				//instanciamos la clase classusuario para almacenar datos de la BD..
			Classempleado clemp=new Classempleado();
			clemp.setCodigoemp(rs.getString(1));
			clemp.setNomemp(rs.getString(2));
			clemp.setDistrito(rs.getString(3));
			clemp.setNumero(rs.getInt(4));
			clemp.setCorreo(rs.getString(5));
			clemp.setCargo(rs.getString(6));
		    listado.add(clemp);
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
	public Classempleado BuscarEmpleado(Classempleado clemp) {
		//instanciamos la clase conectar..
				ConectarBD conex=new ConectarBD();
				//realizamos la cadena o invocamos al prodecimiento almacenado
				String sql="{call BuscarDatosEmpleado(?)}";
				//aplicamos la respectiva interface..
				CallableStatement cs=null;
				ResultSet rs=null;
				//instanciamos la respetiva clase 
				//para almacenar el lote recuperado
				Classempleado alemp= new Classempleado();
				try {
					cs=conex.ConexionMysql().prepareCall(sql);
					//asignamos el parametro
					cs.setString(1,clemp.getCodigoemp());
					rs=cs.executeQuery();
					//aplicamos una condicion 
					if(rs.next()){
						
						alemp.setCodigoemp(rs.getString(1));
						alemp.setNomemp(rs.getString(2));
						alemp.setDistrito(rs.getString(3));
						alemp.setNumero(rs.getInt(4));
						alemp.setCorreo(rs.getString(5));
						alemp.setCargo(rs.getString(6));
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return alemp;
	}

	@Override
	public Classempleado ValidarEmpleado(Classempleado clemp) {
		//instanciamos la clase conectar..
				ConectarBD conex=new ConectarBD();
				//realizamos la cadena o invocamos al prodecimiento almacenado
				String sql="{call Validacodemp(?)}";
				//aplicamos la respectiva interface..
				CallableStatement cs=null;
				ResultSet rs=null;
				//instanciamos la respetiva clase 
				//para almacenar el lote recuperado
				Classempleado almemp= new Classempleado();
				try {
					cs=conex.ConexionMysql().prepareCall(sql);
					//asignamos el parametro
					cs.setString(1,clemp.getCodigoemp());
					rs=cs.executeQuery();
					//aplicamos una condicion 
					if(rs.next()){
						
						almemp.setCodigoemp(rs.getString(1));
						almemp.setNomemp(rs.getString(2));
						almemp.setDistrito(rs.getString(3));
						almemp.setNumero(rs.getInt(4));
						almemp.setCorreo(rs.getString(5));
						almemp.setCargo(rs.getString(6));
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return almemp;
	}

	@Override
	public List<Classempleado> BuscarTabla(String buscar) {
		//instanciamos la clase conectar BD...
		ConectarBD conex=new ConectarBD();
		//realizamos la respectiva cadena en mysql
		String sql="{call BuscarCodyNom(?)}";
		//aplicamos las interfaces para base de datos
		CallableStatement cs=null;
		ResultSet rs=null;
		
		List<Classempleado> listado=new ArrayList<>();
		
		
		try {
			cs=conex.ConexionMysql().prepareCall(sql);
			cs.setString(1,buscar);
			rs=cs.executeQuery();
			
			while(rs.next()){
				//instanciamos la clase classusuario para almacenar datos de la BD..
			Classempleado clemp=new Classempleado();
			clemp.setCodigoemp(rs.getString(1));
			clemp.setNomemp(rs.getString(2));
			clemp.setDistrito(rs.getString(3));
			clemp.setNumero(rs.getInt(4));
			clemp.setCorreo(rs.getString(5));
			clemp.setCargo(rs.getString(6));
		    listado.add(clemp);
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
	public String GenerarCodigoEmp() {
		 ConectarBD conex = new ConectarBD();
		    String nuevoCodigo = null;

		    String sql = "{CALL GenerarCodigoEmp()}";
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
}
