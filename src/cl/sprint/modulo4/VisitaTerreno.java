package cl.sprint.modulo4;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase que representa una visita a terreno.
 */
public class VisitaTerreno {
    private int identificadorVisita; // Número interno de la visita
    private int rutCliente; // RUT del cliente
    private LocalDate diaAccidente; // Día del accidente
    private LocalTime horaVisita; // Hora de la visita
    private String lugar; // Lugar de la visita
    private String comentarios; // Comentarios de la visita
    private List<Revision> revisiones; // Lista de revisiones asociadas a la visita

    /**
     * Constructor de la clase VisitaTerreno.
     *
     * @param identificadorVisita Identificador de la visita en terreno.
     * @param rutCliente          RUT del cliente.
     * @param diaAccidente        Día del accidente.
     * @param horaVisita          Hora de la visita en terreno.
     * @param lugar               Lugar de la visita en terreno.
     * @param comentarios         Comentarios de la visita en terreno.
     */
    public VisitaTerreno(int identificadorVisita, int rutCliente, LocalDate diaAccidente, LocalTime horaVisita,
            String lugar, String comentarios) {
        this.identificadorVisita = identificadorVisita;
        this.rutCliente = rutCliente;
        this.diaAccidente = diaAccidente;
        this.horaVisita = horaVisita;
        this.lugar = lugar;
        this.comentarios = comentarios;
        revisiones = new ArrayList<>();
    }

    /**
     * Obtiene el identificador de la visita en terreno.
     *
     * @return Identificador de la visita en terreno.
     */
    public int getIdentificadorVisita() {
        return identificadorVisita;
    }

    /**
     * Establece el identificador de la visita en terreno.
     *
     * @param identificadorVisita Identificador de la visita en terreno.
     */
    public void setIdentificadorVisita(int identificadorVisita) {
        this.identificadorVisita = identificadorVisita;
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
     * @throws IllegalArgumentException Si el RUT del cliente es inválido.
     */
    public void setRutCliente(int rutCliente) {
        if (rutCliente > 0 && rutCliente <= 99999999) {
            this.rutCliente = rutCliente;
        } else {
            throw new IllegalArgumentException("RUT del cliente inválido. Debe ser un entero menor a 99999999.");
        }
    }

    /**
     * Obtiene la hora de la visita en terreno.
     *
     * @return Hora de la visita en terreno.
     */
    public LocalTime getHoraVisita() {
        return horaVisita;
    }

    /**
     * Establece la hora de la visita en terreno.
     *
     * @param horaVisita Hora de la visita en terreno.
     */
    public void setHoraVisita(LocalTime horaVisita) {
        this.horaVisita = horaVisita;
    }

    /**
     * Obtiene el lugar de la visita en terreno.
     *
     * @return Lugar de la visita en terreno.
     */
    public String getLugar() {
        return lugar;
    }

    /**
     * Establece el lugar de la visita en terreno.
     *
     * @param lugar Lugar de la visita en terreno.
     * @throws IllegalArgumentException Si el lugar no cumple con los requisitos.
     */
    public void setLugar(String lugar) {
        if (lugar != null && lugar.length() >= 10 && lugar.length() <= 50) {
            this.lugar = lugar;
        } else {
            throw new IllegalArgumentException("El lugar debe tener entre 10 y 50 caracteres.");
        }
    }

    /**
     * Obtiene los comentarios de la visita en terreno.
     *
     * @return Comentarios de la visita en terreno.
     */
    public String getComentarios() {
        return comentarios;
    }

    /**
     * Establece los comentarios de la visita en terreno.
     *
     * @param comentarios Comentarios de la visita en terreno.
     * @throws IllegalArgumentException Si los comentarios exceden el límite de
     *                                  caracteres.
     */
    public void setComentarios(String comentarios) {
        if (comentarios != null && comentarios.length() <= 100) {
            this.comentarios = comentarios;
        } else {
            throw new IllegalArgumentException("Los comentarios deben tener como máximo 100 caracteres.");
        }
    }

    /**
     * Representación en forma de cadena de la visita a terreno.
     *
     * @return Cadena que representa la visita a terreno.
     */
    @Override
    public String toString() {
        return "Visita a Terreno [Identificador Visita=" + identificadorVisita + ", RUT Cliente=" + rutCliente
                + "Dia del accidente=" + diaAccidente + ", Hora Visita=" + horaVisita + ", Lugar=" + lugar + ", Comentarios="
                + comentarios + "]";
    }

    /**
     * Agrega una revisión a la lista de revisiones asociadas a la visita en terreno.
     *
     * @param revision La revisión a agregar.
     */
    public void agregarRevision(Revision revision) {
        if (revision != null) {
            revisiones.add(revision);
        }
    }

    /**
     * Obtiene la lista de revisiones asociadas a la visita en terreno.
     *
     * @return Lista de revisiones asociadas a la visita en terreno.
     */
    public List<Revision> getRevisiones() {
        return revisiones;
    }
}


