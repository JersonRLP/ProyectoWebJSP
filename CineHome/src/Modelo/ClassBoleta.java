package Modelo;

public class ClassBoleta {

	private String 	codboleta;
	private String cliente;
	private int cantentra;
	private int idpelicula;
	private String nroasientos;
	private double preciotot;
	
	private String nompelicula;
	//atributods de detaboleta
	
	private String codigoemp;
	
	public String getNompelicula() {
		return nompelicula;
	}
	public void setNompelicula(String nompelicula) {
		this.nompelicula = nompelicula;
	}
	//contructor vacio
	public ClassBoleta() {
		super();
	}
	//contructor de los campos de boleta 
	public ClassBoleta(String codboleta, String cliente, int cantentra, int idpelicula, String nroasientos,
			double preciotot,String nompelicula) {
		super();
		this.codboleta = codboleta;
		this.cliente = cliente;
		this.cantentra = cantentra;
		this.idpelicula = idpelicula;
		this.nroasientos = nroasientos;
		this.preciotot = preciotot;
		this.nompelicula=nompelicula;
	}
	//contructor para el detalle de boleta
	public ClassBoleta(String codboleta, int cantentra, double preciotot, String codigoemp) {
		super();
		this.codboleta = codboleta;
		this.cantentra = cantentra;
		this.preciotot = preciotot;
		this.codigoemp = codigoemp;
	}
	public String getCodboleta() {
		return codboleta;
	}
	public void setCodboleta(String codboleta) {
		this.codboleta = codboleta;
	}
	public String getCliente() {
		return cliente;
	}
	public void setCliente(String cliente) {
		this.cliente = cliente;
	}
	public int getCantentra() {
		return cantentra;
	}
	public void setCantentra(int cantentra) {
		this.cantentra = cantentra;
	}
	public int getIdpelicula() {
		return idpelicula;
	}
	public void setIdpelicula(int idpelicula) {
		this.idpelicula = idpelicula;
	}
	public String getNroasientos() {
		return nroasientos;
	}
	public void setNroasientos(String nroasientos) {
		this.nroasientos = nroasientos;
	}
	public double getPreciotot() {
		return preciotot;
	}
	public void setPreciotot(double preciotot) {
		this.preciotot = preciotot;
	}
	public String getCodigoemp() {
		return codigoemp;
	}
	public void setCodigoemp(String codigoemp) {
		this.codigoemp = codigoemp;
	}
	
	
	//Metodos encapsulados
	
}
