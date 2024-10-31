package Dao.cinehome;

import java.util.List;

import Conectar.Cinehome.ConectarBD;
import Modelo.ClassDetalleBoleta;
import Modelo.Classempleado;

public class TestDetalleBoleta {

	public static void main(String[] args) {
		
		//llamamos al metodo CRUDEMPLEADO
		String buscarcodigo = "EM006";
		DetalleBoletaImp cons = new DetalleBoletaImp();
		List<ClassDetalleBoleta>listar=cons.consulta(buscarcodigo);
		//aplicamos un bucle for...
		for(ClassDetalleBoleta list:listar){
			//imprimimos por consola
			System.out.println(" codigo boleta "+list.getCodboleta()+("\n")+
					" cantidad de entradas "+list.getCantentra()+("\n")+
					" precio total "+list.getPreciotot());

			
		}   //fin del bucle for...*/
		

	}

}
