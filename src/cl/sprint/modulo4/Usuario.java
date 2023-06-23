package cl.sprint.modulo4;


import java.time.LocalDate;

/**
 * Clase Usuario, implementa interfaz IAsesoria
 */
public class Usuario implements IAsesoria {
    private String nombre; // Nombre del usuario
    private LocalDate fechaNacimiento; // Fecha de nacimiento del usuario
    private int run; // RUN del usuario

    public Usuario(String nombre, LocalDate fechaNacimiento, int run) {
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.run = run;
    }

    public Usuario() {
        // Constructor vacío
    }

    /**
     * Obtiene el nombre del usuario.
     *
     * @return Nombre del usuario.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del usuario.
     *
     * @param nombre Nombre del usuario.
     * @throws IllegalArgumentException Si el nombre es nulo o tiene una longitud
     *                                  inválida.
     */
    public void setNombre(String nombre) {
        if (nombre == null) {
            throw new IllegalArgumentException("El nombre no puede ser nulo.");
        }

        if (nombre.length() < 10 || nombre.length() > 50) {
            throw new IllegalArgumentException("El nombre debe tener entre 10 y 50 caracteres.");
        }
        this.nombre = nombre;
    }

    /**
     * Obtiene la fecha de nacimiento del usuario.
     *
     * @return Fecha de nacimiento del usuario.
     */
    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    /**
     * Establece la fecha de nacimiento del usuario.
     *
     * @param fechaNacimiento Fecha de nacimiento del usuario.
     * @throws IllegalArgumentException Si la fecha de nacimiento es nula.
     */
    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        if (fechaNacimiento == null) {
            throw new IllegalArgumentException("La fecha de nacimiento no puede ser nula.");
        }
        this.fechaNacimiento = fechaNacimiento;
    }

    /**
     * Obtiene el RUN del usuario.
     *
     * @return RUN del usuario.
     */
    public int getRun() {
        return run;
    }

    /**
     * Establece el RUN del usuario.
     *
     * @param run RUN del usuario.
     * @throws IllegalArgumentException Si el RUN es inválido.
     */
    public void setRun(int run) {
        if (run >= 99999999) {
            throw new IllegalArgumentException("El RUN debe ser un número menor a 99.999.999.");
        }
        this.run = run;
    }

    /**
     * Muestra la edad del usuario.
     *
     * @return Edad del usuario.
     */
    public String mostrarEdad() {
        LocalDate fechaActual = LocalDate.now();
        int edad = calcularEdad(fechaActual, fechaNacimiento);
        return "El usuario tiene " + edad + " anios.";
    }

    /**
     * Implementación del método `analizarUsuario()` de la interfaz `IAsesoria`.
     * Muestra el nombre y el RUN del usuario.
     */
    @Override
    public void analizarUsuario() {
        System.out.println("Nombre: " + nombre);
        System.out.println("RUN: " + run);
    }

    /**
     * Calcula la edad en años a partir de la fecha de nacimiento y la fecha actual.
     *
     * @param fechaActual     Fecha actual.
     * @param fechaNacimiento Fecha de nacimiento.
     * @return Edad del usuario en años.
     */
    public int calcularEdad(LocalDate fechaActual, LocalDate fechaNacimiento) {
        return fechaNacimiento.until(fechaActual).getYears();
    }

    /**
     * Devuelve una representación en forma de cadena de la instancia de Usuario.
     *
     * @return Representación en forma de cadena de la instancia de Usuario.
     */
    @Override
    public String toString() {
        return "Usuario{" +
                "nombre='" + nombre + '\'' +
                ", fechaNacimiento=" + fechaNacimiento +
                ", run=" + run +
                '}';
    }
}

