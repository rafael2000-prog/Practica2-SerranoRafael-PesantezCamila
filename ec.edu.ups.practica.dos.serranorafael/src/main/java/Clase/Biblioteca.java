package Clase;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Biblioteca {
	private String nombre;
	private String direccion;
	private List<Libro> listaLibro;
	private List<Usuario> listaUsuario;
	
	public Biblioteca() {
		this.listaLibro = new ArrayList<>();
		this.listaUsuario = new ArrayList<>();
	}

	public Biblioteca(String nombre, String direccion) {
		super();
		this.nombre = nombre;
		this.direccion = direccion;
		this.listaLibro = new ArrayList<>();
		this.listaUsuario = new ArrayList<>();
	}

	public Biblioteca(String nombre, String direccion, List<Libro> listaLibro, List<Usuario> listaUsuario) {
		super();
		this.nombre = nombre;
		this.direccion = direccion;
		this.listaLibro = listaLibro;
		this.listaUsuario = listaUsuario;
		this.listaLibro = new ArrayList<>();
		this.listaUsuario = new ArrayList<>();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	public void agregarLibro(Libro libro) {
		listaLibro.add(libro);
	}
	public void registarUsuario(Usuario usuario) {
		listaUsuario.add(usuario);
	}
	
	public Biblioteca(List<Libro> listaLibro, List<Usuario> listaUsuario) {
		super();
		this.listaLibro = listaLibro;
		this.listaUsuario = listaUsuario;
	}
	

	public List<Libro> getListaLibro() {
		return listaLibro;
	}

	public void setListaLibro(List<Libro> listaLibro) {
		this.listaLibro = listaLibro;
	}

	public List<Usuario> getListaUsuario() {
		return listaUsuario;
	}

	public void setListaUsuario(List<Usuario> listaUsuario) {
		this.listaUsuario = listaUsuario;
	}

	public Libro buscarLibro(String titulo) {
	    for (Libro libro : listaLibro) {
	        if (libro.getTitulo().equalsIgnoreCase(titulo)) {
	            return libro;
	        }
	    }
	    System.out.println("Libro no encontrado con el título: " + titulo);
	    return null;
	}

	
	
	public Usuario buscarUsuario(String identificacion) {
	    for (Usuario usuario : listaUsuario) {
	        if (usuario.getIdentificacion().equalsIgnoreCase(identificacion)) {
	            return usuario;
	        }
	    }
	    return null;
	}
	
	public void prestarLibro(Libro libro, Usuario usuario) {
	    if (libro.isDisponible()) {
	        if (!estaLibroPrestado(libro)) {
	            Prestamo prestamo = new Prestamo(libro, usuario, new Date(), null);
	            libro.setDisponible(false);
	            usuario.getListaPrestamo().add(prestamo);
	        } else {
	            System.out.println("El libro ya está prestado a otro usuario.");
	        }
	    } else {
	        System.out.println("El libro no está disponible para préstamo.");
	    }
	}

	private boolean estaLibroPrestado(Libro libro) {
	    for (Usuario usuario : listaUsuario) {
	        for (Prestamo prestamo : usuario.getListaPrestamo()) {
	            if (prestamo.getLibro().equals(libro) && prestamo.getFechaDevolucion() == null) {
	                return true; 
	        }
	    }
	}
		return false;
	}
	
	public void devolverLibro(Libro libro, Usuario usuario) {
		 Prestamo prestamo = buscarPrestamoActivo(libro, usuario);

		    if (prestamo != null) {
		        prestamo.setFechaDevolucion(new Date());
		        libro.setDisponible(true);
		    } 
		}

		private Prestamo buscarPrestamoActivo(Libro libroDevolucion, Usuario usuarioDevolucion) {
		    for (Prestamo prestamo : usuarioDevolucion.getListaPrestamo()) {
		        if (prestamo.getLibro().equals(libroDevolucion) && prestamo.getFechaDevolucion() == null) {
		            return prestamo;
		        }
		    }
		    return null;
		
	}
	

	@Override
	public String toString() {
		return "Biblioteca [nombre=" + nombre + ", direccion=" + direccion + "]";
	}

	


	
	

}
