package Modelo;

public class ClassDetalleBoleta {
private String codboleta;
private String codigoemp;
private int cantentra;
private double preciotot;

public ClassDetalleBoleta() {
	super();
}

public ClassDetalleBoleta(String codboleta, int cantentra, double preciotot) {
	super();
	this.codboleta = codboleta;
	this.cantentra = cantentra;
	this.preciotot = preciotot;
}

public String getCodboleta() {
	return codboleta;
}

public void setCodboleta(String codboleta) {
	this.codboleta = codboleta;
}

public String getCodigoemp() {
	return codigoemp;
}

public void setCodigoemp(String codigoemp) {
	this.codigoemp = codigoemp;
}

public int getCantentra() {
	return cantentra;
}

public void setCantentra(int cantentra) {
	this.cantentra = cantentra;
}

public double getPreciotot() {
	return preciotot;
}

public void setPreciotot(double preciotot) {
	this.preciotot = preciotot;
}


}
