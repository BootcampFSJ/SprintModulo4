package cl.sprint.modulo4;

import java.time.LocalDate;


/**
 * Clase Administrativo, extiende de la clase Usuario, implementa interfaz
 * IAsesoria
 */
public class Administrativo extends Usuario implements IAsesoria {
	private String area; // Área del administrativo
	private String experienciaPrevia; // Experiencia previa del administrativo

	/**
	 * Constructor de la clase Administrativo que recibe todos los atributos.
	 *
	 * @param area              Área del Administrativo
	 * @param experienciaPrevia Experiencia previa del Administrativo
	 */
	public Administrativo(String nombre, LocalDate fechaNacimiento, int run, String area, String experienciaPrevia) {
		super(nombre, fechaNacimiento, run);
		this.area=area;
		this.experienciaPrevia=experienciaPrevia;
	}

	/**
	 * Constructor vacío de la clase Administrativo.
	 */
	public Administrativo() {
		// Constructor vacío
	}

	// Métodos de acceso para el atributo Area
	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		if (area != null && !area.isEmpty() && area.length() >= 5 && area.length() <= 20) {
			this.area = area;
		} else {
			throw new IllegalArgumentException("Debe completar con un mínimo de 5 y un máximo de 20 caracteres.");
		}
	}

	// Métodos de acceso para el atributo Experiencia previa
	public String getExperienciaPrevia() {
		return experienciaPrevia;
	}

	public void setExperienciaPrevia(String experienciaPrevia) {
		if (experienciaPrevia != null && experienciaPrevia.length() <= 100) {
			this.experienciaPrevia = experienciaPrevia;
		} else {
			throw new IllegalArgumentException("Solo se puede escribir un máximo de 100 caracteres.");
		}
	}

	/**
	 * Método analizarUsuario() para mostrar la información del padre y los datos
	 * expuestos en la clase hija.
	 */
	@Override
	public void analizarUsuario() {
		super.analizarUsuario(); // Mostrar información del padre
		System.out.println("Area: " + area); // Mostrar información de la clase hija
		System.out.println("Experiencia Previa: " + experienciaPrevia); // Mostrar información de la clase hija
	}

	/**
	 * Método toString() para obtener una representación en forma de cadena de la
	 * instancia de la clase Administrativo.
	 */
	@Override
	public String toString() {
		return "Administrativo{" + "nombre='" + getNombre() + '\'' + ", fechaNacimiento=" + getFechaNacimiento()
				+ ", run=" + getRun() + ", area='" + area + '\'' + ", experienciaPrevia='" + experienciaPrevia + '\''
				+ '}';
	}
}
