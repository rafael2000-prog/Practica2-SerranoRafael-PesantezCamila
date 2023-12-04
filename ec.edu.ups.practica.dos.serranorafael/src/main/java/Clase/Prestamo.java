package Clase;

import java.util.Date;

public class Prestamo {

	private Libro libro;
	private Usuario usuario;
	private Date fechaPrestamo;
	private Date fechaDevolucion;
	
	public Prestamo() {
		
	}

	public Prestamo(Libro libro, Usuario usuario, Date fechaPrestamo, Date fechaDevolucion) {
		super();
		this.libro = libro;
		this.usuario = usuario;
		this.fechaPrestamo = fechaPrestamo;
		this.fechaDevolucion = fechaDevolucion;
	}

	public Prestamo(Date fechaPrestamo, Date fechaDevolucion) {
		super();
		this.fechaPrestamo = fechaPrestamo;
		this.fechaDevolucion = fechaDevolucion;
	}

	public Libro getLibro() {
		return libro;
	}

	public void setLibro(Libro libro) {
		this.libro = libro;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Date getFechaPrestamo() {
		return fechaPrestamo;
	}

	public void setFechaPrestamo(Date fechaPrestamo) {
		this.fechaPrestamo = fechaPrestamo;
	}

	public Date getFechaDevolucion() {
		return fechaDevolucion;
	}

	public void setFechaDevolucion(Date fechaDevolucion) {
		this.fechaDevolucion = fechaDevolucion;
	}

	public int calcularDiasPrestamo() {
		long diferenciaEnMillis = fechaDevolucion.getTime() - fechaPrestamo.getTime();
		long diasPrestamo = diferenciaEnMillis/(24*3600*1000);
		
		return (int) diasPrestamo;
	}

	

	

	
	
	
	
}
