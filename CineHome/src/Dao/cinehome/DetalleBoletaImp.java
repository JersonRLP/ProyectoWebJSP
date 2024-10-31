package Dao.cinehome;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Conectar.Cinehome.ConectarBD;
import Interfaces.IntDetalleBoleta;
import Modelo.ClassDetalleBoleta;
import Modelo.Classempleado;

public class DetalleBoletaImp implements IntDetalleBoleta{

	@Override
	public List<ClassDetalleBoleta> consulta(String buscarcodigo) {
		//instanciamos la clase conectar BD...
				ConectarBD conex=new ConectarBD();
				//realizamos la respectiva cadena en mysql
				String sql="{call ConsultaVentaEmp(?)}";
				//aplicamos las interfaces para base de datos
				CallableStatement cs=null;
				ResultSet rs=null;
				
				List<ClassDetalleBoleta> listado=new ArrayList<>();
				
				
				try {
					cs=conex.ConexionMysql().prepareCall(sql);
					cs.setString(1,buscarcodigo);
					rs=cs.executeQuery();
					
					while(rs.next()){
						//instanciamos la clase classusuario para almacenar datos de la BD..
					ClassDetalleBoleta cldtbol=new ClassDetalleBoleta();
					cldtbol.setCodboleta(rs.getString(1));
					cldtbol.setCantentra(rs.getInt(2));
					cldtbol.setPreciotot(rs.getDouble(3));
					
				    listado.add(cldtbol);
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
	public List<ClassDetalleBoleta> ListarcodEmp() {
		//instanciamos la clase conectar BD...
		ConectarBD conex=new ConectarBD();
		//realizamos la respectiva cadena en mysql
		String sql="call ListarcodEmp";
		//aplicamos las interfaces para base de datos
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		List<ClassDetalleBoleta> listado=new ArrayList<>();
		
		
		try {
			ps=conex.ConexionMysql().prepareStatement(sql);
			rs=ps.executeQuery();
			
			while(rs.next()){
				//instanciamos la clase classusuario para almacenar datos de la BD..
			ClassDetalleBoleta cldtbol=new ClassDetalleBoleta();
			cldtbol.setCodigoemp(rs.getString(1));
			
		    listado.add(cldtbol);
		    }//fin del bucle
		
		}
			catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//realizamos la ejecucion
		
			return listado;
	}

}
