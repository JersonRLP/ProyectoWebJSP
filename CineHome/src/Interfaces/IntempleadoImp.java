package Interfaces;

import java.util.List;

import Modelo.Classempleado;

public interface IntempleadoImp {

	void RegistrarEmpleado(Classempleado clemp);
	void ActualizarEmpleado(Classempleado clemp);
	void EliminarEmpleado(Classempleado clemp);
	List<Classempleado> listarEmpleado(); 
	Classempleado BuscarEmpleado(Classempleado clemp);
	Classempleado ValidarEmpleado(Classempleado clem);
	List<Classempleado> BuscarTabla(String buscar);
	String GenerarCodigoEmp();
}
