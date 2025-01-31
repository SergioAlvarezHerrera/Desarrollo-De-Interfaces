package cineapp;

import java.io.Serializable;

public class Pelicula implements Serializable {
    private String titulo;
    private String tipo;
    private String resumen;
    private String imagePath;

    public Pelicula(String titulo, String tipo, String resumen, String imagePath) {
        this.titulo = titulo;
        this.tipo = tipo;
        this.resumen = resumen;
        this.imagePath = imagePath;
    }
    
    public Pelicula() {
    	
    }

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getResumen() {
		return resumen;
	}

	public void setResumen(String resumen) {
		this.resumen = resumen;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public String getRutaImagen() {
		// TODO Auto-generated method stub
		return null;
	}

    
}
