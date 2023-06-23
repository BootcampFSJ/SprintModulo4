package cl.sprint.modulo4;

/**
 * Clase Revisión, que representa una revisión asociada a una visita en terreno.
 */
public class Revision {
	private int idRevision; // Identificador de la revisión: número interno manejado por la compañía
	private int idVisitaTerreno; // Identificador de la visita en terreno asociada a la revisión
	private String nombreRevision; // Nombre alusivo a la revisión: mínimo 10 caracteres, máximo 50
	private String detalleRevisar; // Detalle para revisar: máximo 100 caracteres
	private int estado; // Estado: 1 (sin problemas), 2 (con observaciones), 3 (no aprueba)

	/**
	 * Constructor de la clase Revision.
	 *
	 * @param idRevision      Identificador de la revisión.
	 * @param idVisitaTerreno Identificador de la visita en terreno asociada a la
	 *                        revisión.
	 * @param nombreRevision  Nombre alusivo a la revisión.
	 * @param detalleRevisar  Detalle para revisar.
	 * @param estado          Estado de la revisión.
	 */
	public Revision(int idRevision, int idVisitaTerreno, String nombreRevision, String detalleRevisar, int estado) {
		this.setIdRevision(idRevision);
		this.setIdVisitaTerreno(idVisitaTerreno);
		this.setNombreRevision(nombreRevision);
		this.setDetalleRevisar(detalleRevisar);
		this.setEstado(estado);
	}
	
	/**
	 * Constructor vacío de la clase Revision.
	 */
	public Revision() {
	}

	/**
	 * Obtiene el identificador de la revisión.
	 *
	 * @return El identificador de la revisión.
	 */
	public int getIdRevision() {
		return idRevision;
	}

	/**
	 * Establece el identificador de la revisión.
	 *
	 * @param idRevision El identificador de la revisión.
	 * @throws IllegalArgumentException Si el identificador es menor o igual a cero.
	 */
	public void setIdRevision(int idRevision) {
		if (idRevision <= 0) {
			throw new IllegalArgumentException("El identificador de revisión debe ser mayor a cero.");
		}
		this.idRevision = idRevision;
	}

	/**
	 * Obtiene el identificador de la visita en terreno asociada a la revisión.
	 *
	 * @return El identificador de la visita en terreno.
	 */
	public int getIdVisitaTerreno() {
		return idVisitaTerreno;
	}

	/**
	 * Establece el identificador de la visita en terreno asociada a la revisión.
	 *
	 * @param idVisitaTerreno El identificador de la visita en terreno.
	 * @throws IllegalArgumentException Si el identificador es menor o igual a cero.
	 */
	public void setIdVisitaTerreno(int idVisitaTerreno) {
		if (idVisitaTerreno <= 0) {
			throw new IllegalArgumentException("El identificador de visita en terreno debe ser mayor a cero.");
		}
		this.idVisitaTerreno = idVisitaTerreno;
	}

	/**
	 * Obtiene el nombre alusivo a la revisión.
	 *
	 * @return El nombre alusivo a la revisión.
	 */
	public String getNombreRevision() {
		return nombreRevision;
	}

	/**
	 * Establece el nombre alusivo a la revisión.
	 *
	 * @param nombreRevision El nombre alusivo a la revisión.
	 * @throws IllegalArgumentException Si el nombre es nulo, tiene menos de 10
	 *                                  caracteres o más de 50 caracteres.
	 */
	public void setNombreRevision(String nombreRevision) {
		if (nombreRevision == null || nombreRevision.length() < 10 || nombreRevision.length() > 50) {
			throw new IllegalArgumentException("El nombre de la revisión debe tener entre 10 y 50 caracteres.");
		}
		this.nombreRevision = nombreRevision;
	}

	/**
	 * Obtiene el detalle para revisar.
	 *
	 * @return El detalle para revisar.
	 */
	public String getDetalleRevisar() {
		return detalleRevisar;
	}

	/**
	 * Establece el detalle para revisar.
	 *
	 * @param detalleRevisar El detalle para revisar.
	 * @throws IllegalArgumentException Si el detalle supera los 100 caracteres.
	 */
	public void setDetalleRevisar(String detalleRevisar) {
		if (detalleRevisar != null && detalleRevisar.length() > 100) {
			throw new IllegalArgumentException("El detalle para revisar debe tener como máximo 100 caracteres.");
		}
		this.detalleRevisar = detalleRevisar;
	}

	/**
	 * Obtiene el estado de la revisión.
	 *
	 * @return El estado de la revisión.
	 */
	public int getEstado() {
		return estado;
	}

	/**
	 * Establece el estado de la revisión.
	 *
	 * @param estado El estado de la revisión.
	 * @throws IllegalArgumentException Si el estado no es 1, 2 o 3.
	 */
	public void setEstado(int estado) {
		if (estado != 1 && estado != 2 && estado != 3) {
			throw new IllegalArgumentException(
					"El estado debe ser 1 (sin problemas), 2 (con observaciones) o 3 (no aprueba).");
		}
		this.estado = estado;
	}

	/**
	 * Obtiene el estado de la revisión como cadena.
	 *
	 * @return El estado de la revisión como cadena.
	 */
	public String obtenerEstado() {
		String estadoStr;
		switch (estado) {
		case 1:
			estadoStr = "Sin problemas";
			break;
		case 2:
			estadoStr = "Con observaciones";
			break;
		case 3:
			estadoStr = "No aprueba";
			break;
		default:
			estadoStr = "Estado inválido";
			break;
		}
		return estadoStr;
	}

	/**
	 * Devuelve una representación en cadena de la revisión.
	 *
	 * @return La representación en cadena de la revisión.
	 */
	@Override
	public String toString() {
		return "Revision{" + "idRevision=" + idRevision + ", idVisitaTerreno=" + idVisitaTerreno + ", nombreRevision='"
				+ nombreRevision + '\'' + ", detalleRevisar='" + detalleRevisar + '\'' + ", estado=" + estado + '}';
	}
}
