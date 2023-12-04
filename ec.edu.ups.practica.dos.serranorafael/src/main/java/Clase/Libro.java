package Clase;

public class Libro extends Persona {
	private String titulo;
	private String autor;
	private int año;
	private boolean disponible;
	
	public Libro() {
		
	}

	public Libro(String titulo, String autor, int año, boolean disponible) {
		super();
		this.titulo = titulo;
		this.autor = autor;
		this.año = año;
		this.disponible = disponible;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public int getAño() {
		return año;
	}

	public void setAño(int año) {
		this.año = año;
	}

	public boolean isDisponible() {
		return disponible;
	}

	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}
	
	public void prestar() {
		
	}
	public void devolver() {
		
	}

	@Override
	public String mostrarInformacion() {
	    return "titulo: " + titulo + "\nautor: " + autor + "\naño: " + año ;
	}

}
