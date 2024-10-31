package Interfaces;

import java.util.List;

import Modelo.ClassDetalleBoleta;


public interface IntDetalleBoleta {

	List<ClassDetalleBoleta> consulta(String buscarcodigo);
	List<ClassDetalleBoleta> ListarcodEmp();
}
