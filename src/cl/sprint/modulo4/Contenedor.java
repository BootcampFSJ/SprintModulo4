package cl.sprint.modulo4;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Clase Contenedor, que representa un contenedor con la lista asesorias, 
 * que almacena a los Usuarios, y la lista capacitaciones, que almacena
 * las capacitaciones
 */
public class Contenedor {
	public List<IAsesoria> asesorias;
	public List<Capacitacion> capacitaciones;

	/**
	 * Constructor de la clase Contenedor. Inicializa las listas asesorias y
	 * capacitaciones.
	 */
	public Contenedor() {
		asesorias = new ArrayList<>();
		capacitaciones = new ArrayList<>();
	}

	/**
	 * Almacena un cliente en la lista asesorias.
	 *
	 * @param cliente El cliente a almacenar.
	 */
	public void almacenarCliente(Cliente cliente) {
		asesorias.add(cliente);
	}

	/**
	 * Almacena un profesional en la lista asesorias.
	 *
	 * @param profesional El profesional a almacenar.
	 */
	public void almacenarProfesional(Profesional profesional) {
		asesorias.add(profesional);
	}

	/**
	 * Almacena un administrativo en la lista asesorias.
	 *
	 * @param administrativo El administrativo a almacenar.
	 */
	public void almacenarAdministrativo(Administrativo administrativo) {
		asesorias.add(administrativo);
	}

	/**
	 * Almacena una capacitación en la lista de capacitaciones.
	 *
	 * @param capacitacion La capacitación a almacenar.
	 */
	public void almacenarCapacitacion(Capacitacion capacitacion) {
		capacitaciones.add(capacitacion);
	}

	/**
	 * Elimina un usuario de la lista asesorias dado su RUN.
	 *
	 * @param run El RUN del usuario a eliminar.
	 */
	public boolean eliminarUsuario(int run) {
	    Iterator<IAsesoria> iterator = asesorias.iterator();
	    while (iterator.hasNext()) {
	        IAsesoria asesoria = iterator.next();
	        if (asesoria instanceof Usuario) {
	            Usuario usuario = (Usuario) asesoria;
	            if (usuario.getRun() == run) {
	                iterator.remove();
	                return true; // Usuario encontrado y eliminado correctamente
	            }
	        }
	    }
	    return false; // Usuario no encontrado
	}


	/**
	 * Lista los usuarios presentes en la lista asesorias y muestra su información.
	 */
	public void listarUsuarios() {
	    for (IAsesoria asesoria : asesorias) {
	        if (asesoria instanceof Usuario) {
	            Usuario usuario = (Usuario) asesoria;
	            usuario.analizarUsuario();
	            System.out.println("Edad: " + usuario.mostrarEdad());
	            System.out.println("------------------------");
	        }
	    }
	}

	/**
	 * Lista los usuarios de un tipo específico presentes en la lista asesorias.
	 *
	 * @param tipo El tipo de usuario a listar ("cliente", "administrativo" o
	 *             "profesional").
	 */
	public void listarUsuariosPorTipo(String tipo) {
		for (IAsesoria asesoria : asesorias) {
			if (asesoria instanceof Usuario) {
				Usuario usuario = (Usuario) asesoria;
				
				if (tipo.equalsIgnoreCase("cliente") && usuario instanceof Cliente) {
					Cliente cliente = (Cliente) usuario;
					System.out.println("\nDatos del Cliente:");
					cliente.analizarUsuario();
					System.out.println("Telefono: " + cliente.getTelefono());
					System.out.println("AFP: " + cliente.getAfp());
					System.out.println("Sistema de Salud: " + (cliente.obtenerSistemaSalud()));
					System.out.println("Nombre Completo: " + cliente.obtenerNombre());
					System.out.println("------------------------");
					
				} else if (tipo.equalsIgnoreCase("administrativo") && usuario instanceof Administrativo) {
					Administrativo administrativo = (Administrativo) usuario;
					System.out.println("\nDatos del Administrativo:");
					administrativo.analizarUsuario();
					System.out.println("------------------------");
					
				} else if (tipo.equalsIgnoreCase("profesional") && usuario instanceof Profesional) {
					Profesional profesional = (Profesional) usuario;
					System.out.println("\nDatos del Profesional:");
					profesional.analizarUsuario();
					System.out.println("------------------------");
				}
			}
		}
	}

	// Otros métodos de la clase Contenedor...

	/**
	 * Obtiene la lista asesorias.
	 *
	 * @return La lista asesorias.
	 */
	public List<IAsesoria> getAsesorias() {
		return asesorias;
	}

	/**
	 * Establece la lista asesorias.
	 *
	 * @param asesorias La lista asesorias a establecer.
	 */
	public void setAsesorias(List<IAsesoria> asesorias) {
		this.asesorias = asesorias;
	}

	/**
	 * Obtiene la lista de capacitaciones almacenadas.
	 *
	 * @return La lista de capacitaciones.
	 */
	public List<Capacitacion> getCapacitaciones() {
		return capacitaciones;
	}

	/**
	 * Establece la lista de capacitaciones.
	 *
	 * @param capacitaciones La lista de capacitaciones a establecer.
	 */
	public void setCapacitaciones(List<Capacitacion> capacitaciones) {
		this.capacitaciones = capacitaciones;
	}

	/**
	 * Lista las capacitaciones presentes en la lista de capacitaciones.
	 */
	public void listarCapacitaciones() {
	    if (capacitaciones.isEmpty()) {
	        System.out.println("\nNo hay capacitaciones disponibles.");
	        return;
	    }
	    
	    for (Capacitacion capacitacion : capacitaciones) {
			System.out.println("\nDatos de la Capacitacion:");
	        System.out.println("Identificador: " + capacitacion.getIdentificador());
	        System.out.println("RUT del cliente: " + capacitacion.getRutCliente());
	        System.out.println("Dia de la capacitacion: " + capacitacion.getDia());
	        System.out.println("Hora de la capacitacion: " + capacitacion.getHora());
	        System.out.println("Lugar de la capacitacion: " + capacitacion.getLugar());
	        System.out.println("Duracion de la capacitacion (minutos): " + capacitacion.getDuracion());
	        System.out.println("Cantidad de asistentes: " + capacitacion.getCantidadAsistentes());
	        System.out.println("Detalle de la capacitacion: " + capacitacion.mostrarDetalle());

	        Cliente clienteAsociado = null;
	        for (IAsesoria asesoria : asesorias) {
	            if (asesoria instanceof Cliente) {
	                Cliente cliente = (Cliente) asesoria;
	                if (cliente.getRutCliente() == capacitacion.getRutCliente()) {
	                    clienteAsociado = cliente;
	                    break;
	                }
	            }
	        }
	        
	        if (clienteAsociado != null) {
	            System.out.println("\nDatos del cliente asociado:");
	            clienteAsociado.analizarUsuario();
	            
	        } else {
	            System.out.println("\nNo hay cliente asociado a esta capacitacion.");
	        }
	        
	        System.out.println("------------------------");
	    }
	}
}

