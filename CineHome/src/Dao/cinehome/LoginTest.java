package Dao.cinehome;

import java.util.List;

import Modelo.ClassUsuario;
import Modelo.Classempleado;

public class LoginTest {

	public static void main(String[] args) {
		//testlistadousuario();
		testbuscardatousu();
	}
	
	static void testlistadousuario(){
		UsuarioImp crudusu = new  UsuarioImp();
		
		List<ClassUsuario> listar = crudusu.ListadoUsuario();
		
		for(ClassUsuario list:listar){
			//imprimimos por consola
			System.out.println(" codigo "+list.getCodigoemp()+("\n")+
					" Usuario "+list.getUsuario()+("\n")+
					" Password "+list.getPassword());

			
		}   //fin del bucle for...*/
	}
	static void testbuscardatousu(){
		
		//llamamos al metodo CRUDEMPLEADO
				ClassUsuario codigo= new ClassUsuario();
				UsuarioImp crudusu = new UsuarioImp();
				codigo.setCodigoemp("EM001");
				ClassUsuario resultado= crudusu.BuscarDatosUsuario(codigo);

					System.out.println(" codigo "+resultado.getCodigoemp()+("\n")+
							" usuario "+resultado.getUsuario()+("\n")+
							" Password "+resultado.getPassword());
		
	}
}
