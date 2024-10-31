package Modelo;

import java.io.InputStream;

public class ClassPelicula {
	private int idpelicula;
	private String nompelicula;
	private String fotopelicula;
	
	
	public ClassPelicula(String nompelicula, String fotopelicula) {
		
		this.nompelicula = nompelicula;
		this.fotopelicula = fotopelicula;
	}
	public ClassPelicula() {
		
	}
	
	public ClassPelicula(int idpelicula) {
		super();
		this.idpelicula = idpelicula;
	}
	public ClassPelicula(int idpelicula, String nompelicula, String fotopelicula) {
		super();
		this.idpelicula = idpelicula;
		this.nompelicula = nompelicula;
		this.fotopelicula = fotopelicula;
	}
	public int getIdpelicula() {
		return idpelicula;
	}
	public void setIdpelicula(int idpelicula) {
		this.idpelicula = idpelicula;
	}
	public String getNompelicula() {
		return nompelicula;
	}
	public void setNompelicula(String nompelicula) {
		this.nompelicula = nompelicula;
	}
	public String getFotopelicula() {
		return fotopelicula;
	}
	public void setFotopelicula(String fotopelicula) {
		this.fotopelicula = fotopelicula;
	}
	
	
}
