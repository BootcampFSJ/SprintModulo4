package cl.sprint.modulo4;

import java.time.LocalDate;

import java.util.List;
import java.util.ArrayList;

/**
 * Clase Cliente, extiende de la clase Usuario, implementa interfaz IAsesoria
 */
public class Cliente extends Usuario implements IAsesoria {

	private int rutCliente; // RUT del cliente
	private String nombres; // Nombres del cliente
	private String apellidos; // Apellidos del cliente
	private String telefono; // Teléfono del cliente
	private String afp; // AFP del cliente
	private int sistemaSalud; // 1 (Fonasa) o 2 (Isapre), debe ser solo una de las dos opciones
	private String direccion; // Dirección del cliente
	private String comuna; // Comuna del cliente
	private int edad; // Edad del cliente
	private List<Capacitacion> capacitaciones; // Capacitaciones del cliente
	private List<Accidente> accidentes; // Accidentes registrados por el cliente
	private List<VisitaTerreno> visitasTerreno; // Visitas en terreno del cliente

	/**
	 * Constructor vacío de la clase Cliente.
	 */
	public Cliente() {
		super(null, null, 0);
		capacitaciones = new ArrayList<>();
		accidentes = new ArrayList<>();
		visitasTerreno = new ArrayList<>();
	}

	/**
	 * Constructor de la clase Cliente.
	 *
	 * @param nombre          Nombre del cliente.
	 * @param fechaNacimiento Fecha de nacimiento del cliente.
	 * @param run             RUN del cliente.
	 * @param rutCliente      RUT del cliente.
	 * @param nombres         Nombres del cliente.
	 * @param apellidos       Apellidos del cliente.
	 * @param telefono        Teléfono del cliente.
	 * @param afp             AFP del cliente.
	 * @param sistemaSalud    Sistema de salud del cliente (1 para Fonasa, 2 para
	 *                        Isapre).
	 * @param direccion       Dirección del cliente.
	 * @param comuna          Comuna del cliente.
	 * @param edad            Edad del cliente.
	 */
	public Cliente(String nombre, LocalDate fechaNacimiento, int run, int rutCliente, String nombres, String apellidos,
			String telefono, String afp, int sistemaSalud, String direccion, String comuna, int edad) {
		super(nombre, fechaNacimiento, run);
		this.rutCliente = rutCliente;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.telefono = telefono;
		this.afp = afp;
		this.sistemaSalud = sistemaSalud;
		this.direccion = direccion;
		this.comuna = comuna;
		this.edad = edad;
		capacitaciones = new ArrayList<>();
		accidentes = new ArrayList<>();
	}

	// Getters y setters

	/**
	 * Obtiene el RUT del cliente.
	 *
	 * @return RUT del cliente.
	 */
	public int getRutCliente() {
		return rutCliente;
	}

	/**
	 * Establece el RUT del cliente.
	 *
	 * @param rutCliente RUT del cliente.
	 * @throws IllegalArgumentException Si el RUT no cumple con los requisitos.
	 */
	public void setRutCliente(int rutCliente) {
	    if (rutCliente > 0 && rutCliente < 99999999) {
	        this.rutCliente = rutCliente;
	    } else {
	        throw new IllegalArgumentException("El RUT del cliente debe ser un entero mayor a 0 y menor a 99999999");
	    }
	}


	/**
	 * Obtiene los nombres del cliente.
	 *
	 * @return Nombres del cliente.
	 */
	public String getNombres() {
		return nombres;
	}

	/**
	 * Establece los nombres del cliente.
	 *
	 * @param nombres Nombres del cliente.
	 * @throws IllegalArgumentException Si los nombres no cumplen con los
	 *                                  requisitos.
	 */
	public void setNombres(String nombres) {
		if (nombres != null && !nombres.isEmpty() && nombres.length() >= 5 && nombres.length() <= 30) {
			this.nombres = nombres;
		} else {
			throw new IllegalArgumentException("Los nombres deben tener entre 5 y 30 caracteres");
		}
	}

	/**
	 * Obtiene los apellidos del cliente.
	 *
	 * @return Apellidos del cliente.
	 */
	public String getApellidos() {
		return apellidos;
	}

	/**
	 * Establece los apellidos del cliente.
	 *
	 * @param apellidos Apellidos del cliente.
	 * @throws IllegalArgumentException Si los apellidos no cumplen con los
	 *                                  requisitos.
	 */
	public void setApellidos(String apellidos) {
		if (apellidos != null && !apellidos.isEmpty() && apellidos.length() >= 5 && apellidos.length() <= 30) {
			this.apellidos = apellidos;
		} else {
			throw new IllegalArgumentException("Los apellidos deben tener entre 5 y 30 caracteres");
		}
	}

	/**
	 * Obtiene la edad del cliente.
	 *
	 * @return Edad del cliente.
	 */
	public int getEdad() {
		return edad;
	}

	/**
	 * Obtiene el teléfono del cliente.
	 *
	 * @return Teléfono del cliente.
	 */
	public String getTelefono() {
		return telefono;
	}

	/**
	 * Establece el teléfono del cliente.
	 *
	 * @param telefono Teléfono del cliente.
	 * @throws IllegalArgumentException Si el teléfono es nulo o vacío.
	 */
	public void setTelefono(String telefono) {
		if (telefono != null && !telefono.isEmpty()) {
			this.telefono = telefono;
		} else {
			throw new IllegalArgumentException("El teléfono es obligatorio");
		}
	}

	/**
	 * Obtiene la AFP del cliente.
	 *
	 * @return AFP del cliente.
	 */
	public String getAfp() {
		return afp;
	}

	/**
	 * Establece la AFP del cliente.
	 *
	 * @param afp AFP del cliente.
	 * @throws IllegalArgumentException Si la AFP es nula o vacía.
	 */
	public void setAfp(String afp) {
	    if (afp != null && !afp.isEmpty() && afp.length() >= 4 && afp.length() <= 30) {
	        this.afp = afp;
	    } else {
	        throw new IllegalArgumentException("La AFP es obligatoria y debe tener entre 4 y 30 caracteres");
	    }
	}


	/**
	 * Obtiene el sistema de salud del cliente.
	 *
	 * @return Sistema de salud del cliente ("Fonasa", "Isapre" o "Desconocido").
	 */
	public String obtenerSistemaSalud() {
		if (sistemaSalud == 1) {
			return "Fonasa";
		} else if (sistemaSalud == 2) {
			return "Isapre";
		} else {
			return "Desconocido";
		}
	}

	/**
	 * Establece el sistema de salud del cliente.
	 *
	 * @param sistemaSalud Sistema de salud del cliente (1 para Fonasa, 2 para
	 *                     Isapre).
	 * @throws IllegalArgumentException Si el sistema de salud no es válido.
	 */
	public void setSistemaSalud(int sistemaSalud) {
		if (sistemaSalud == 1 || sistemaSalud == 2) {
			this.sistemaSalud = sistemaSalud;
		} else {
			throw new IllegalArgumentException("El sistema de salud debe ser 1 (Fonasa) o 2 (Isapre)");
		}
	}

	/**
	 * Obtiene la dirección del cliente.
	 *
	 * @return Dirección del cliente.
	 */
	public String getDireccion() {
		return direccion;
	}

	/**
	 * Establece la dirección del cliente.
	 *
	 * @param direccion Dirección del cliente.
	 * @throws IllegalArgumentException Si la dirección es nula o vacía.
	 */
	public void setDireccion(String direccion) {
	    if (direccion != null && !direccion.isEmpty() && direccion.length() <= 70) {
	        this.direccion = direccion;
	    } else {
	        throw new IllegalArgumentException("La dirección es obligatoria y debe tener un máximo de 70 caracteres");
	    }
	}

	/**
	 * Obtiene la comuna del cliente.
	 *
	 * @return Comuna del cliente.
	 */
	public String getComuna() {
		return comuna;
	}

	/**
	 * Establece la comuna del cliente.
	 *
	 * @param comuna Comuna del cliente.
	 * @throws IllegalArgumentException Si la comuna es nula o vacía.
	 */
	public void setComuna(String comuna) {
	    if (comuna != null && !comuna.isEmpty() && comuna.length() <= 50) {
	        this.comuna = comuna;
	    } else {
	        throw new IllegalArgumentException("La comuna es obligatoria y debe tener un máximo de 50 caracteres");
	    }
	}
	
	/**
	 * Establece la edad del cliente.
	 *
	 * @param edad Edad del cliente.
	 * @throws IllegalArgumentException Si la edad es un valor negativo.
	 */
	public void setEdad(int edad) {
	    if (edad >= 0 && edad < 150) {
	        this.edad = edad;
	    } else {
	        throw new IllegalArgumentException("La edad debe ser un número entero mayor o igual a 0 y menor a 150");
	    }
	}

	// Métodos

	/**
	 * Obtiene el nombre completo del cliente.
	 *
	 * @return Nombre completo del cliente.
	 */
	public String obtenerNombre() {
		return nombres + " " + apellidos;
	}

	/**
	 * Devuelve una representación en forma de cadena de la instancia de Cliente.
	 *
	 * @return Representación en forma de cadena de la instancia de Cliente.
	 */
	@Override
	public String toString() {
		return "Cliente [rutCliente=" + rutCliente + ", nombres=" + nombres + ", apellidos=" + apellidos + ", edad="
				+ edad + ", telefono=" + telefono + ", afp=" + afp + ", sistemaSalud=" + sistemaSalud + ", direccion="
				+ direccion + ", comuna=" + comuna + "]";
	}

	/**
	 * Muestra la información del usuario y agrega la dirección y comuna del
	 * cliente.
	 */
	@Override
	public void analizarUsuario() {
		super.analizarUsuario(); // Mostrar información del padre
		System.out.println("Direccion: " + direccion); // Mostrar dirección del cliente
		System.out.println("Comuna: " + comuna); // Mostrar comuna del cliente
	}

	/**
	 * Agrega una capacitacion al cliente.
	 *
	 * @param capacitacion La capacitacion a agregar.
	 */
	public void agregarCapacitacion(Capacitacion capacitacion) {
		capacitacion.setCliente(this);
		capacitaciones.add(capacitacion);
	}

	/**
	 * Muestra las capacitaciones del cliente.
	 */
	public void mostrarCapacitaciones() {
		System.out.println("Capacitaciones del cliente:");
		if (capacitaciones.isEmpty()) {
			System.out.println("No tiene capacitaciones registradas");
		} else {
			for (Capacitacion capacitacion : capacitaciones) {
				System.out.println(capacitacion);
			}
		}
	}

	/**
	 * Agrega un accidente al cliente.
	 *
	 * @param accidente El accidente a agregar.
	 */
	public void agregarAccidente(Accidente accidente) {
		accidentes.add(accidente);
	}

	/**
	 * Muestra los accidentes registrados por el cliente.
	 */
	public void mostrarAccidentes() {
		System.out.println("Accidentes registrados por el cliente:");
		if (accidentes.isEmpty()) {
			System.out.println("No tiene accidentes registrados");
		} else {
			for (Accidente accidente : accidentes) {
				System.out.println(accidente);
			}
		}
	}

	/**
	 * Agrega una visita en terreno al cliente.
	 *
	 * @param visita La visita a agregar.
	 */
	public void agregarVisitaTerreno(VisitaTerreno visita) {
		// Verificar que la visita no sea nula
		if (visita != null) {
			visitasTerreno.add(visita);
		} else {
			throw new IllegalArgumentException("La visita en terreno no puede ser nula");
		}
	}

	/**
	 * Muestra las visitas en terreno asociadas al cliente.
	 */
	public void mostrarVisitasTerreno() {
		System.out.println("Visitas en terreno del cliente:");
		if (visitasTerreno.isEmpty()) {
			System.out.println("No tiene visitas en terreno registradas");
		} else {
			for (VisitaTerreno visita : visitasTerreno) {
				System.out.println(visita);
			}
		}
	}
}