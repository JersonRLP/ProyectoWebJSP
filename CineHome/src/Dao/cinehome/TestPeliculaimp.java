package Dao.cinehome;

import java.util.List;

import Modelo.ClassPelicula;

public class TestPeliculaimp {

	public static void main(String[] args) {
		
		ClassPelicula clpel = new ClassPelicula();
		PeliculaImp pelimp = new PeliculaImp();
		
		List<ClassPelicula> listado = pelimp.ListarPelicula();
		for(ClassPelicula listar:listado){
			System.out.println("codigo " + listar.getIdpelicula()+ "Nombre " + listar.getNompelicula() + "Foto" + listar.getFotopelicula());
		}

	}

}
