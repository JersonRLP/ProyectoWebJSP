package Modelo;

public class Classempleado {
private String codigoemp;
private String nomemp;
private String distrito;
private int numero;
private String correo;
private String cargo;

//contructor vacio Empleado
public Classempleado() {
	super();
}
//contructor con todos los campos 

public Classempleado(String codigoemp, String nomemp, String distrito, int numero, String correo, String cargo) {
	super();
	this.codigoemp = codigoemp;
	this.nomemp = nomemp;
	this.distrito = distrito;
	this.numero = numero;
	this.correo = correo;
	this.cargo = cargo;
}

public String getCodigoemp() {
	return codigoemp;
}

public void setCodigoemp(String codigoemp) {
	this.codigoemp = codigoemp;
}

public String getNomemp() {
	return nomemp;
}

public void setNomemp(String nomemp) {
	this.nomemp = nomemp;
}

public String getDistrito() {
	return distrito;
}

public void setDistrito(String distrito) {
	this.distrito = distrito;
}

public int getNumero() {
	return numero;
}

public void setNumero(int numero) {
	this.numero = numero;
}

public String getCorreo() {
	return correo;
}

public void setCorreo(String correo) {
	this.correo = correo;
}

public String getCargo() {
	return cargo;
}

public void setCargo(String cargo) {
	this.cargo = cargo;
}

//Metedos get y setters


	
}
