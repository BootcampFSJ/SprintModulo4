package cl.sprint.modulo4;

import java.time.LocalTime;

/**
 * Clase Capacitación. Incluye métodos para acceder y modificar los atributos.
 */
public class Capacitacion {
	private int identificador; // Número interno de la capacitación, int, tipo private.
	private int rutCliente; // RUT del cliente, int, tipo private.
	private String dia; // Día de la Capacitación, string, tipo private.
	private LocalTime hora; // Hora de la Capacitación, string, tipo private.
	private String lugar; // Lugar de la Capacitación, string, tipo private.
	private String duracion; // Duración de la Capacitación (minutos), int, tipo private.
	private int cantidad; // Cantidad de Asistentes, int, tipo private.
	private Cliente cliente; // Cliente asociado a la capacitación


	/**
	 * Constructor vacío de la clase Capacitacion.
	 */
	public Capacitacion() {
	}

	/**
	 * Constructor de la clase Capacitacion que recibe todos los atributos.
	 *
	 * @param identificador Número interno de la capacitación.
	 * @param rutCliente    RUT del cliente.
	 * @param dia           Día de la capacitación.
	 * @param hora          Hora de la capacitación.
	 * @param lugar         Lugar de la capacitación.
	 * @param duracion      Duración de la capacitación (minutos).
	 * @param cantidad      Cantidad de asistentes a la capacitación.
	 */
	public Capacitacion(int identificador, int rutCliente, String dia, LocalTime hora, String lugar, String duracion,
			int cantidad, Cliente cliente) {
		this.identificador = identificador;
		this.rutCliente=rutCliente;
		this.dia = dia;
		this.hora = hora;
		this.lugar = lugar;
		this.duracion = duracion;
		this.cantidad = cantidad;
		 this.cliente = cliente;
	}

	/**
	 * Método toString() Devuelve una representación en cadena de texto del objeto
	 * RegistroCapacitacion.
	 *
	 * @return La representación en cadena de texto del objeto.
	 */
	@Override
	public String toString() {
		return "Registro Capacitacion{" + "rutCliente=" + rutCliente + ", identificador='" + identificador + '\''
				+ ", dia='" + dia + '\'' + ", hora='" + hora + '\'' + ", lugar='" + lugar + '\'' + ", duracion="
				+ duracion + '}';
	}
	
	
	/**
	 * Obtiene el Identificador de la capacitacion.
	 *
	 * @return Identificador de la Capacitacion.
	 */
	public int getIdentificador() {
	    return identificador;
	}

	/**
	 * Establece el Identificador de la capacitación.
	 *
	 * @param identificador Identificador de la capacitación.
	 * @throws IllegalArgumentException Si el identificador no es un número entero válido.
	 */
	public void setIdentificador(int identificador) {
	    if (identificador > 0) {
	        this.identificador = identificador;
	    } else {
	        throw new IllegalArgumentException("El identificador debe ser un número entero válido.");
	    }
	}



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
	 * @throws IllegalArgumentException Si el RUT del cliente no es un entero menor
	 *                                  a 99999999.
	 */
	public void setRutCliente(int rutCliente) {
		if (rutCliente > 0 && rutCliente < 99999999) {
			this.rutCliente = rutCliente;
		} else {
			throw new IllegalArgumentException("El RUT del cliente debe ser un entero menor a 99999999");
		}
	}

	/**
	 * Obtiene el día de la capacitación.
	 *
	 * @return El día de la capacitación.
	 */
	public String getDia() {
		return dia;
	}

	/**
	 * Establece el día de la capacitación.
	 *
	 * @param dia El día de la capacitación.
	 */
	public void setDia(String dia) {
		if (isValidDia(dia)) {
			this.dia = dia;
		} else {
			throw new IllegalArgumentException("Día inválido. Debe ser un día entre lunes y domingo.");
		}
	}

	/**
	 * Verifica si el día ingresado es válido.
	 *
	 * @param dia El día a verificar.
	 * @return true si el día es válido, false de lo contrario.
	 */
	public boolean isValidDia(String dia) {
		String[] diasValidos = { "Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado", "Domingo" };
		for (String diaValido : diasValidos) {
			if (diaValido.equalsIgnoreCase(dia)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Obtiene la hora de la capacitación.
	 *
	 * @return La hora de la capacitación.
	 */
	public LocalTime getHora() {
		return hora;
	}

	/**
	 * Establece la hora de la capacitación.
	 *
	 * @param hora La hora de la capacitación.
	 */
	public void setHora(LocalTime hora) {
		this.hora = hora;
	}

	/**
	 * Obtiene el lugar de la capacitación.
	 *
	 * @return El lugar de la capacitación.
	 */
	public String getLugar() {
		return lugar;
	}

	/**
	 * Establece el lugar de la capacitación.
	 *
	 * @param lugar El lugar de la capacitación.
	 * @throws IllegalArgumentException Si el lugar no cumple con los requisitos de
	 *                                  tamaño.
	 */
	public void setLugar(String lugar) {
		if (lugar != null && !lugar.isEmpty() && lugar.length() >= 10 && lugar.length() <= 50) {
			this.lugar = lugar;
		} else {
			throw new IllegalArgumentException("Lugar debe tener, mínimo 10 caracteres, máximo 50");
		}
	}

	/**
	 * Obtiene la duración de la capacitación.
	 *
	 * @return La duración de la capacitación.
	 */
	public String getDuracion() {
		return duracion;
	}

	/**
	 * Establece la duración de la capacitación.
	 *
	 * @param duracion La duración de la capacitación.
	 * @throws IllegalArgumentException Si la duración no cumple con los requisitos
	 *                                  de tamaño.
	 */
	public void setDuracion(String duracion) {
		if (duracion != null && !duracion.isEmpty() && duracion.length() <= 70) {
			this.duracion = duracion;
		} else {
			throw new IllegalArgumentException("Duracion debe tener un maximo de 70 caracteres");
		}
	}

	/**
	 * Obtiene la cantidad de asistentes a la capacitación.
	 *
	 * @return La cantidad de asistentes a la capacitación.
	 */
	public int getCantidadAsistentes() {
		return cantidad;
	}

	/**
	 * Establece la cantidad de asistentes a la capacitación.
	 *
	 * @param cantidad La cantidad de asistentes a la capacitación.
	 * @throws IllegalArgumentException Si la cantidad de asistentes no es un valor
	 *                                  válido.
	 */
	public void setCantidadAsistentes(int cantidad) {
		if (cantidad > 0 && cantidad <= 1000) {
			this.cantidad = cantidad;
		} else {
			throw new IllegalArgumentException("Maximo 1000 asistentes");
		}
	}

	/**
	 * Devuelve un mensaje que dice "La capacitación será en A a las B del día C, y
	 * durará D minutos", donde A es el lugar, B es la hora, C es el día y D son los
	 * minutos.
	 *
	 * @return El mensaje con lugar, hora, día y minutos.
	 */
	public String mostrarDetalle() {
		return "La capacitacion sera en " + lugar + " a las " + hora + " del dia " + dia + ", y durara " + duracion
				+ " minutos.";
	}
	
	/**
	 * Obtiene el cliente asociado a la capacitación.
	 *
	 * @return Obtiene el cliente asociado a la capacitación.
	 */
	
	public Cliente getCliente() {
	    return cliente;
	}
	
	/**
	 * Establece el cliente asociado a la capacitación.
	 *
	 * @param el cliente asociado a la capacitación
	 */
	
	public void setCliente(Cliente cliente) {
	    this.cliente = cliente;
	}
}
