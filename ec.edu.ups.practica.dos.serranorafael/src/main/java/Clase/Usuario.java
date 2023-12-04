package Clase;

import java.util.ArrayList;

public class Usuario extends Persona {
	private String correo;
	private ArrayList<Prestamo> listaPrestamo;
	
	public Usuario() {
		this.setListaPrestamo(new ArrayList<>());
		
	}
	
	public Usuario(String correo) {
		super();
		this.correo = correo;
		this.setListaPrestamo(new ArrayList<>());
	}
	public Usuario(String nombre, String identificacion, String correo) {
		super(nombre, identificacion);
		this.correo = correo;
		this.setListaPrestamo(new ArrayList<>());
	}
	

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}


	@Override
	public String mostrarInformacion() {
		
		return super.toString() + "Usuario [correo=" + correo + "]";
	}
	
	public String solicitarPrestamo(Libro libro) {
		return null;
		
	}
	public int devolverLibro(Libro libro) {
		return 0;
		
	}

	public ArrayList<Prestamo> getListaPrestamo() {
		return listaPrestamo;
	}

	public void setListaPrestamo(ArrayList<Prestamo> listaPrestamo) {
		this.listaPrestamo = listaPrestamo;
	}
	

}
