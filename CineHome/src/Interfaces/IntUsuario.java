package Interfaces;

import java.util.List;

import Modelo.ClassUsuario;

public interface IntUsuario {

	void RegistrarUsuario(ClassUsuario clusu);
	void ActualizarUsuario(ClassUsuario clusu);
	void EliminarUsuario(ClassUsuario clusu);
	ClassUsuario BuscarDatosUsuario(ClassUsuario clusu);
	List<ClassUsuario> ListadoUsuario();
	List<ClassUsuario> BuscarUsuario(String buscar);
	ClassUsuario ValidarUsuario(ClassUsuario clusu);
	ClassUsuario ValidacodUsu(ClassUsuario clusu);
}
