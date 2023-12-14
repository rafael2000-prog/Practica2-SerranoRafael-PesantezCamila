package Test;

import java.util.Scanner;

import Clase.Biblioteca;
import Clase.Libro;
import Clase.Usuario;

public class Principal {

	public static void main(String[] args) {
		Biblioteca biblioteca = new Biblioteca("Biblioteca Municipal", " benigno Malo Calle Principal");
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("Bienvenido al Sistema de Gestión de Biblioteca");
            System.out.println("1. Agregar Libro");
            System.out.println("2. Registrar Usuario");
            System.out.println("3. Buscar Libro");
            System.out.println("4. Prestar Libro");
            System.out.println("5. Devolver Libro");
            System.out.println("6. Salir");
            System.out.print("Ingrese una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); 
            switch (opcion) {
                case 1:
                    System.out.println("Ingrese los datos del libro:");
                    System.out.print("Título: ");
                    String tituloLibro = scanner.nextLine();
                    System.out.print("Autor: ");
                    String autorLibro = scanner.nextLine();
                    System.out.print("Año: ");
                    int añoLibro = scanner.nextInt();
                    scanner.nextLine(); 

                    Libro nuevoLibro = new Libro(tituloLibro, autorLibro, añoLibro, true);
                    biblioteca.agregarLibro(nuevoLibro);
                    System.out.println("Libro agregado exitosamente.");
                    break;

                case 2:
                  
                    System.out.println("Ingrese los datos del usuario:");
                    System.out.print("Nombre: ");
                    String nombreUsuario = scanner.nextLine();
                    System.out.print("Identificación: ");
                    String identificacionUsuario = scanner.nextLine();
                    System.out.print("Correo: ");
                    String correoUsuario = scanner.nextLine();

                    Usuario nuevoUsuario = new Usuario(nombreUsuario, identificacionUsuario, correoUsuario);
                    biblioteca.registarUsuario(nuevoUsuario);
                    System.out.println("Usuario registrado exitosamente.");
                    break;

                case 3:
                	int opcion1;
                	do {
                		System.out.println("1. Busqueda por titulo");
                        System.out.println("2. Busqueda por año");
                        System.out.println("3. Busqueda por autor");
                        System.out.println("4. Salir");
                        opcion1 = scanner.nextInt();
                        switch(opcion1) {
                        
                        case 1:
                        	System.out.print("Ingrese el título del libro a buscar: ");
                            String tituloBusqueda = scanner.next();
                            Libro libroBusqueda = biblioteca.buscarLibro(tituloBusqueda);
                            if (libroBusqueda != null) {
                                System.out.println("Resultados de la búsqueda:");
                                System.out.println(libroBusqueda.mostrarInformacion());
                            } else {
                                System.out.println("Libro no encontrado.");
                            }
                            break;

                            
                        case 2:
                        	System.out.print("Ingrese el año del libro a buscar: ");
                            int añoBusqueda = scanner.nextInt();
                            Libro libroBusquedaAño = biblioteca.buscarLibroAño(añoBusqueda);
                            if (libroBusquedaAño != null) {
                                System.out.println("Resultados de la búsqueda:");
                                System.out.println(libroBusquedaAño.mostrarInformacion());
                            } else {
                                System.out.println("Libro no encontrado.");
                            }
                        	break;
                        	
                        case 3:
                        	System.out.print("Ingrese el autor del libro a buscar: ");
                        	String autorBusqueda = scanner.next();
                        	Libro libroBusquedaAutor = biblioteca.buscarLibroAutor(autorBusqueda);
                        	if (libroBusquedaAutor != null) {
                                System.out.println("Resultados de la búsqueda:");
                                System.out.println(libroBusquedaAutor.mostrarInformacion());
                            } else {
                                System.out.println("Libro no encontrado.");
                            }
                            break;
                        
                        case 4:
                        	System.out.println("Saliendo de busqueda");
                        	break;
                            
                        default:
                            System.out.println("Opción no válida. Por favor intente de nuevo.");
                        }
                        
                	}while (opcion1 != 4);
                	
                    break;
                case 4:
                    System.out.print("Ingrese el título del libro a prestar: ");
                    String tituloPrestamo = scanner.nextLine();
                    
                    Libro libroPrestamo = biblioteca.buscarLibro(tituloPrestamo);

                    if (libroPrestamo != null) {
                        System.out.print("Ingrese la identificación del usuario: ");
                        String identificacionUsuarioPrestamo = scanner.nextLine();

                        Usuario usuarioPrestamo = biblioteca.buscarUsuario(identificacionUsuarioPrestamo);

                        if (usuarioPrestamo != null) {
                            biblioteca.prestarLibro(libroPrestamo, usuarioPrestamo);
                            System.out.println("Libro prestado a " + usuarioPrestamo.getNombre() + ".");
                        } else {
                            System.out.println("Usuario no encontrado con la identificación: " + identificacionUsuarioPrestamo);
                        }
                    } else {
                        System.out.println("Libro no encontrado.");
                    }
                    break;
                    
                case 5:
                	System.out.print("Ingrese el título del libro a devolver: ");
                    String tituloDevolucion = scanner.nextLine();
                    
                    Libro libroDevolucion = biblioteca.buscarLibro(tituloDevolucion);

                    if (libroDevolucion != null) {
                        System.out.print("Ingrese la identificación del usuario que devuelve el libro: ");
                        String identificacionUsuarioDevolucion = scanner.nextLine();

                        Usuario usuarioDevolucion = biblioteca.buscarUsuario(identificacionUsuarioDevolucion);

                        if (usuarioDevolucion != null) {
                            biblioteca.devolverLibro(libroDevolucion, usuarioDevolucion);
                            System.out.println("Libro devuelto por " + usuarioDevolucion.getNombre() + ".");
                        } else {
                            System.out.println("Usuario no encontrado.");
                        }
                    } else {
                        System.out.println("Libro no encontrado.");
                    }
                	
                    
                    break;

                case 6:
                    System.out.println("Saliendo del sistema...");
                    break;

                default:
                    System.out.println("Opción no válida. Por favor intente de nuevo.");
            }
        } while (opcion != 6);

        scanner.close();
    }
}
		
