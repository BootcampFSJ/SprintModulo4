package cl.sprint.modulo4;

import java.text.SimpleDateFormat;
import java.time.LocalDate;

/**
 * Clase que representa un accidente.
 */
public class Accidente {
	private int identificadorAccidente; // Número interno del accidente, int, tipo private.
	private int rutCliente; // RUT del cliente.
	public LocalDate diaAccidente; // Día del accidente, Date, tipo private.
	private String hora; // Hora del accidente, string, tipo private.
	private String lugar; // Lugar del accidente, string, tipo private.
	private String origen; // Origen del accidente, string, tipo private.
	private String consecuencias; // Consecuencias del accidente, string, tipo private.

	/**
	 * Constructor vacío de la clase Accidente.
	 */
	public Accidente() {
	}

	/**
	 * Constructor de la clase Accidente que recibe todos los parámetros.
	 *
	 * @param identificadorAccidente Identificador del accidente.
	 * @param rutCliente             RUT del cliente.
	 * @param dia                    Día del accidente.
	 * @param hora                   Hora del accidente.
	 * @param lugar                  Lugar del accidente.
	 * @param origen                 Origen del accidente.
	 * @param consecuencias          Consecuencias del accidente.
	 */
	public Accidente(int identificadorAccidente, int rutCliente, LocalDate diaAccidente, String hora, String lugar, String origen,
			String consecuencias) {
		this.identificadorAccidente = identificadorAccidente;
		this.rutCliente = rutCliente;
		this.diaAccidente = diaAccidente;
		this.hora = hora;
		this.lugar = lugar;
		this.origen = origen;
		this.consecuencias = consecuencias;
	}

	/**
	 * Obtiene el identificador del accidente.
	 *
	 * @return Identificador del accidente.
	 */
	public int getIdentificadorAccidente() {
		return identificadorAccidente;
	}

	/**
	 * Establece el identificador del accidente.
	 *
	 * @param identificadorAccidente Identificador del accidente.
	 * @throws IllegalArgumentException Si el identificador del accidente es menor o
	 *                                  igual a 0.
	 */
	public void setIdentificadorAccidente(int identificadorAccidente) {
		if (identificadorAccidente > 0) {
			this.identificadorAccidente = identificadorAccidente;
		} else {
			throw new IllegalArgumentException("El identificador del accidente debe ser mayor a 0");
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
	 * Obtiene el día del accidente.
	 *
	 * @return Día del accidente.
	 */
	public LocalDate getDia() {
		return diaAccidente;
	}

	/**
	 * Establece el día del accidente.
	 *
	 * @param dia Día del accidente.
	 * @throws IllegalArgumentException Si el día del accidente es nulo.
	 */
	public void setLocalDia(LocalDate diaAccidente) {
		if (diaAccidente != null) {
			this.diaAccidente = diaAccidente;
		} else {
			throw new IllegalArgumentException("El día del accidente es obligatorio");
		}
	}

	/**
	 * Obtiene la hora del accidente.
	 *
	 * @return Hora del accidente.
	 */
	public String getHora() {
		return hora;
	}

	/**
	 * Establece la hora del accidente.
	 *
	 * @param hora Hora del accidente.
	 * @throws IllegalArgumentException Si la hora no tiene un formato válido
	 *                                  (HH:MM).
	 */
	public void setHora(String hora) {
		if (hora != null && hora.matches("([01]?[0-9]|2[0-3]):[0-5][0-9]")) {
			this.hora = hora;
		} else {
			throw new IllegalArgumentException("La hora debe tener un formato válido (HH:MM)");
		}
	}

	/**
	 * Obtiene el lugar del accidente.
	 *
	 * @return Lugar del accidente.
	 */
	public String getLugar() {
		return lugar;
	}

	/**
	 * Establece el lugar del accidente.
	 *
	 * @param lugar Lugar del accidente.
	 * @throws IllegalArgumentException Si el lugar del accidente no cumple con los
	 *                                  requisitos.
	 */
	public void setLugar(String lugar) {
		if (lugar != null && lugar.length() >= 10 && lugar.length() <= 50) {
			this.lugar = lugar;
		} else {
			throw new IllegalArgumentException("El lugar del accidente debe tener entre 10 y 50 caracteres");
		}
	}

	/**
	 * Obtiene el origen del accidente.
	 *
	 * @return Origen del accidente.
	 */
	public String getOrigen() {
		return origen;
	}

	/**
	 * Establece el origen del accidente.
	 *
	 * @param origen Origen del accidente.
	 * @throws IllegalArgumentException Si el origen del accidente excede el límite
	 *                                  de caracteres.
	 */
	public void setOrigen(String origen) {
		if (origen == null || origen.length() <= 100) {
			this.origen = origen;
		} else {
			throw new IllegalArgumentException("El origen del accidente debe tener máximo 100 caracteres");
		}
	}

	/**
	 * Obtiene las consecuencias del accidente.
	 *
	 * @return Consecuencias del accidente.
	 */
	public String getConsecuencias() {
		return consecuencias;
	}

	/**
	 * Establece las consecuencias del accidente.
	 *
	 * @param consecuencias Consecuencias del accidente.
	 * @throws IllegalArgumentException Si las consecuencias del accidente exceden
	 *                                  el límite de caracteres.
	 */
	public void setConsecuencias(String consecuencias) {
		if (consecuencias == null || consecuencias.length() <= 100) {
			this.consecuencias = consecuencias;
		} else {
			throw new IllegalArgumentException("Las consecuencias del accidente deben tener máximo 100 caracteres");
		}
	}

	/**
	 * Representación en forma de cadena del accidente.
	 *
	 * @return Cadena que representa el accidente.
	 */
	@Override
	public String toString() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		return "Accidente [identificadorAccidente=" + identificadorAccidente + ", rutCliente=" + rutCliente + ", dia="
				+ dateFormat.format(diaAccidente) + ", hora=" + hora + ", lugar=" + lugar + ", origen=" + origen
				+ ", consecuencias=" + consecuencias + "]";
	}
}
