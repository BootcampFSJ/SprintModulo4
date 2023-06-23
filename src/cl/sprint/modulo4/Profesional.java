package cl.sprint.modulo4;

import java.time.LocalDate;

/**
 * Clase Profesional, extiende de la clase Usuario, implementa interfaz
 * IAsesoria
 */
public class Profesional extends Usuario implements IAsesoria {
    private String titulo; // Título del profesional
    private LocalDate fechaIngreso; // Fecha de ingreso del profesional

    /**
     * Constructor de la clase Profesional.
     *
     * @param nombre          Nombre del profesional.
     * @param fechaNacimiento Fecha de nacimiento del profesional.
     * @param run             RUN del profesional.
     * @param titulo          Título del profesional.
     * @param fechaIngreso    Fecha de ingreso del profesional.
     */
    public Profesional(String nombre, LocalDate fechaNacimiento, int run, String titulo, LocalDate fechaIngreso) {
        super(nombre, fechaNacimiento, run);
        this.titulo = titulo;
        this.fechaIngreso = fechaIngreso;
    }

    /**
     * Constructor vacío de la clase Profesional.
     */
    public Profesional() {
        // Constructor vacío
    }

    /**
     * Obtiene el título del profesional.
     *
     * @return Título del profesional.
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * Establece el título del profesional.
     *
     * @param titulo Título del profesional.
     * @throws IllegalArgumentException Si el título no cumple con los requisitos.
     */
    public void setTitulo(String titulo) {
        if (titulo != null && !titulo.isEmpty() && titulo.length() >= 10 && titulo.length() <= 50) {
            this.titulo = titulo;
        } else {
            throw new IllegalArgumentException("El título debe tener entre 10 y 50 caracteres.");
        }
    }

    /**
     * Obtiene la fecha de ingreso del profesional.
     *
     * @return Fecha de ingreso del profesional.
     */
    public LocalDate getFechaIngreso() {
        return fechaIngreso;
    }

    /**
     * Establece la fecha de ingreso del profesional.
     *
     * @param fechaIngreso Fecha de ingreso del profesional.
     * @throws IllegalArgumentException Si la fecha de ingreso es nula.
     */
    public void setFechaIngreso(LocalDate fechaIngreso) {
        if (fechaIngreso != null) {
            this.fechaIngreso = fechaIngreso;
        } else {
            throw new IllegalArgumentException("La fecha de ingreso es obligatoria.");
        }
    }

    /**
     * Método para analizar y mostrar la información del profesional. Muestra la
     * información del padre (Usuario) y los datos específicos de la clase hija
     * (Profesional).
     */
    @Override
    public void analizarUsuario() {
        super.analizarUsuario(); // Muestra información del padre
        System.out.println("Titulo: " + titulo); // Muestra información de la clase hija
        System.out.println("Fecha de Ingreso: " + fechaIngreso); // Muestra información de la clase hija
    }

    /**
     * Representación en forma de cadena del profesional.
     *
     * @return Cadena que representa al profesional.
     */
    @Override
    public String toString() {
        return "Profesional{" +
                "titulo='" + titulo + '\'' +
                ", fechaIngreso=" + fechaIngreso +
                '}';
    }
}

