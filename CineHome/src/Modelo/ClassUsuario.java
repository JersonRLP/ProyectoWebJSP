package Modelo;

public class ClassUsuario {
private String codigoemp;
private String usuario;
private String password;

public ClassUsuario() {
	
}

public ClassUsuario(String codigoemp, String usuario, String password) {
	super();
	this.codigoemp = codigoemp;
	this.usuario = usuario;
	this.password = password;
}

public String getCodigoemp() {
	return codigoemp;
}

public void setCodigoemp(String codigoemp) {
	this.codigoemp = codigoemp;
}

public String getUsuario() {
	return usuario;
}

public void setUsuario(String usuario) {
	this.usuario = usuario;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}



}
