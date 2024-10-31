package Interfaces;

import java.util.List;



import Modelo.ClassPelicula;

public interface IntPeliculaImp {
	void RegistrarPelicula(ClassPelicula clpel);
	void ActualizarPelicula(ClassPelicula clpel);
	void EliminarPelicula(ClassPelicula clpel);
	List<ClassPelicula> ListarPelicula();
	ClassPelicula BuscarPelicula(ClassPelicula clpel);
	List<ClassPelicula> BuscarTabla(String buscar);
	ClassPelicula buscaNompeli(ClassPelicula clpel);
	String BuscarRuta (int idPelicula);
}
