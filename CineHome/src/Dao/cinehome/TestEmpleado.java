package Dao.cinehome;

import java.util.List;

import Modelo.Classempleado;

public class TestEmpleado {

	public static void main(String[] args) {
		//RegistrarEmpleadoTest();
		//ActualizarEmpleadoTest();
		//ListarEmpleadoTest();
		Buscaremp();
	}
	
	static void RegistrarEmpleadoTest(){
		//instanciamos un nuevo empleado
		Classempleado clemp = new Classempleado();
		//llamamos al metodo donde se encuentro el registrarempleado
		EmpleadoImp crudemp = new EmpleadoImp();
		//asignamos un nuevo empleado
		clemp.setCodigoemp("EM003");
		clemp.setNomemp("Pacho");
		clemp.setDistrito("El Agustino");
		clemp.setNumero(948484484);
		clemp.setCorreo("Pacho@gmail.com");
		clemp.setCargo("Cajero");
		//llamamos al metodo addempleado
		crudemp.RegistrarEmpleado(clemp);
		
		
		
	}
	
	/**
	 * 
	 */
	static void ActualizarEmpleadoTest(){
		//instanciamos la clase empleado
		Classempleado clemp = new Classempleado();
		//llamamos al metodo CRUDEMPLEADO
		EmpleadoImp crudemp = new EmpleadoImp();
		//Actualizamos empleado
		clemp.setCodigoemp("EM001");
		clemp.setNomemp("topson");
		clemp.setDistrito("san juan de lurigancho");
		clemp.setNumero(999999999);
		clemp.setCorreo("tomas@hotmail.com");
		clemp.setCargo("Cajero");
		//llamamos al metodo actualizar empleado
		crudemp.ActualizarEmpleado(clemp);
	}
	static void ListarEmpleadoTest(){
			
				//llamamos al metodo CRUDEMPLEADO
				EmpleadoImp crudemp = new EmpleadoImp();
				List<Classempleado>listar=crudemp.listarEmpleado();
				//aplicamos un bucle for...
				for(Classempleado list:listar){
					//imprimimos por consola
					System.out.println(" codigo "+list.getCodigoemp()+("\n")+
							" nombre "+list.getNomemp()+("\n")+
							" Distrito "+list.getDistrito()+("\n")+
							" Numero "+list.getNumero()+("\n")+
							" Correo "+list.getCorreo()+("\n")+
							" Cargo "+list.getCargo());

					
				}   //fin del bucle for...*/
				
	}
	
	static void Buscaremp(){
		//llamamos al metodo CRUDEMPLEADO
		EmpleadoImp crudemp = new EmpleadoImp();
		String buscar="EM001";
		List<Classempleado>listar=crudemp.BuscarTabla(buscar);
		
		for(Classempleado list:listar){
			//imprimimos por consola
			System.out.println(" codigo "+list.getCodigoemp()+("\n")+
					" nombre "+list.getNomemp()+("\n")+
					" Distrito "+list.getDistrito()+("\n")+
					" Numero "+list.getNumero()+("\n")+
					" Correo "+list.getCorreo()+("\n")+
					" Cargo "+list.getCargo());

			
		}   //fin del bucle for...*/
		
	}
}
