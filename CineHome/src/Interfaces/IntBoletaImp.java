package Interfaces;

import Modelo.ClassBoleta;

public interface IntBoletaImp {

	void RegistrarBoleta(ClassBoleta bol);
	void RegistrarDetalleBoleta(ClassBoleta bol);
	String generarNumeroBoleta();
}
