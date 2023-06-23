package cl.sprint.modulo4;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;
import java.time.LocalTime;

/**
 * Clase Principal que contiene un menú de opciones para ejecutar los métodos
 * del Operador.
 *
 * @author Grupo 3: Gabriela Moya, Daniela Inostroza, Camila Fabbroni, Enrique
 *         Crespo, Omar Sepúlveda
 * @since 21-06-2023
 */
public class Principal {

	/**
	 * Método principal que permite crear instancias de cliente, profesional,
	 * administrativo, capacitacion. También permite eliminar usuarios, listar
	 * usuarios según sus datos generales y por tipo, y listar capacitaciones.
	 *
	 * @param args Los argumentos ingresados por el usuario.
	 */

	public static void main(String[] args) {
		Contenedor contenedor = new Contenedor();
		Scanner scanner = new Scanner(System.in);
		int opcion;

		// Menú de opciones
		do {
			System.out.println();
			System.out.println("----- Menu Principal -----");
			System.out.println("1. Almacenar cliente");
			System.out.println("2. Almacenar profesional");
			System.out.println("3. Almacenar administrativo");
			System.out.println("4. Almacenar capacitacion");
			System.out.println("5. Eliminar usuario");
			System.out.println("6. Listar usuarios");
			System.out.println("7. Listar usuarios por tipo");
			System.out.println("8. Listar capacitaciones");
			System.out.println("9. Salir del programa");
			System.out.print("\nIngrese una opcion: ");
			opcion = scanner.nextInt();

			scanner.nextLine();// Consumir salto de línea para evitar errores en lectura de los datos

			/**
			 * Inicializar las variables de Cliente, Profesional y Administrativo, para
			 * poder invocar a sus objetos desde cualquier parte del código.
			 */
			Cliente cliente = new Cliente();
			Profesional profesional = new Profesional();
			Administrativo administrativo = new Administrativo();

			switch (opcion) {

			// Case 1: Almacenar Cliente
			case 1:
				String nombre;
				do {
					System.out.print("\nIngrese nombres y apellidos del cliente (entre 10 y 50 caracteres): ");
					nombre = scanner.nextLine();

					if (nombre.length() < 10 || nombre.length() > 50) {
						System.out.println("El nombre debe tener entre 10 y 50 caracteres.");
					}
				} while (nombre.isEmpty() || nombre.length() < 10 || nombre.length() > 50);

				LocalDate fechaNacimiento = null;
				do {
					System.out.print("Ingrese la fecha de nacimiento del cliente (formato: dd-mm-aaaa): ");
					String fechaNacimientoStr = scanner.nextLine();
					DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
					try {
						fechaNacimiento = LocalDate.parse(fechaNacimientoStr, formatter);
						break;
					} catch (DateTimeParseException e) {
						System.out.println("Error: Fecha de nacimiento en formato invalido.");
					}
				} while (true);

				Integer run = null;
				do {
				    System.out.print("Run (sin puntos ni guion ni digito verificador): ");
				    String runStr = scanner.nextLine();
				    if (runStr.isEmpty()) {
				        System.out.println("Error: Run invalido. Intentelo nuevamente.");
				        continue;
				    }
				    try {
				        run = Integer.parseInt(runStr);
				        if (run < 0 || run > 99999999) {
				            System.out.println("Error: Run invalido. Intentelo nuevamente.");
				        }
				    } catch (NumberFormatException e) {
				        System.out.println("Error: Run invalido. Intentelo nuevamente.");
				    }
				} while (run == null || run < 0 || run > 99999999);


				Integer rutCliente = null;
				do {
				    System.out.print("Ingrese el RUT del cliente (sin puntos ni guion ni digito verificador): ");
				    String rutClienteStr = scanner.nextLine();
				    if (rutClienteStr.isEmpty()) {
				        System.out.println("Error: Rut invalido. Intentelo nuevamente.");
				        continue;
				    }
				    try {
				        rutCliente = Integer.parseInt(rutClienteStr);
				        if (rutCliente < 0 || rutCliente > 99999999) {
				            System.out.println("Error: Rut invalido. Intentelo nuevamente.");
				        }
				    } catch (NumberFormatException e) {
				        System.out.println("Error: Rut invalido. Intentelo nuevamente.");
				    }
				} while (rutCliente == null || rutCliente < 0 || rutCliente > 99999999);


				String nombres;
				do {
					System.out.print("Ingrese los nombres del cliente (entre 5 y 30 caracteres): ");
					nombres = scanner.nextLine();

					if (nombres.isEmpty() || nombres.length() < 5 || nombres.length() > 30) {
						System.out.println(
								"Error: El nombre debe tener entre 5 y 30 caracteres. Por favor, ingrese nuevamente.");
					}
				} while (nombres.isEmpty() || nombres.length() < 5 || nombres.length() > 30);

				String apellidos;
				do {
					System.out.print("Ingrese los apellidos del cliente (entre 5 y 30 caracteres): ");
					apellidos = scanner.nextLine();

					if (apellidos.isEmpty() || apellidos.length() < 5 || apellidos.length() > 30) {
						System.out.println(
								"Error: Los apellidos del cliente deben tener entre 5 y 30 caracteres. Por favor, ingrese nuevamente.");
					}
				} while (apellidos.isEmpty() || apellidos.length() < 5 || apellidos.length() > 30);

				String telefono;
				do {
					System.out.print("Ingrese el telefono del cliente: ");
					telefono = scanner.nextLine();

					if (telefono.isEmpty()) {
						System.out.println("Error: El telefono es obligatorio. Por favor, ingrese un telefono valido.");
					}
				} while (telefono.isEmpty());

				String afp;
				do {
					System.out.print("Ingrese la AFP del cliente: ");
					afp = scanner.nextLine();

					if (afp.isEmpty() || afp.length() < 4 || afp.length() > 30) {
						System.out.println("Error: La AFP debe tener un minimo de 4 caracteres y un maximo de 30.");
					}
				} while (afp.isEmpty() || afp.length() < 4 || afp.length() > 30);

				Integer sistemaSalud = null;
				do {
				    System.out.print("Ingrese el sistema de salud del cliente (1: FONASA, 2: ISAPRE): ");
				    String sistemaSaludStr = scanner.nextLine();
				    if (sistemaSaludStr.isEmpty()) {
				        System.out.println("Valor invalido. Por favor, ingrese 1 para FONASA o 2 para ISAPRE.");
				        continue;
				    }
				    try {
				        sistemaSalud = Integer.parseInt(sistemaSaludStr);
				        if (sistemaSalud != 1 && sistemaSalud != 2) {
				            System.out.println("Valor invalido. Por favor, ingrese 1 para FONASA o 2 para ISAPRE.");
				        }
				    } catch (NumberFormatException e) {
				        System.out.println("Valor invalido. Por favor, ingrese 1 para FONASA o 2 para ISAPRE.");
				    }
				} while (sistemaSalud == null || (sistemaSalud != 1 && sistemaSalud != 2));

				String direccion;
				do {
					System.out.print("Ingrese la direccion del cliente: ");
					direccion = scanner.nextLine();

					if (direccion.isEmpty() || direccion.length() > 70) {
						System.out.println("La direccion es obligatoria y debe tener un maximo de 70 caracteres.");
					}
				} while (direccion.isEmpty() || direccion.length() > 70);

				String comuna;
				do {
					System.out.print("Ingrese la comuna del cliente: ");
					comuna = scanner.nextLine();

					if (comuna.isEmpty() || comuna.length() > 50) {
						System.out.println(
								"Error: La comuna es obligatoria y debe tener hasta 50 caracteres. Por favor, ingrese nuevamente.");
					}
				} while (comuna.isEmpty() || comuna.length() > 50);

				Integer edad = null;
				do {
				    try {
				        System.out.print("Ingrese la edad del cliente: ");
				        String input = scanner.nextLine();
				        edad = Integer.parseInt(input);

				        if (edad < 0 || edad >= 150) {
				            System.out.println("La edad debe ser un valor mayor o igual a 0 y menor a 150. Por favor, ingrese un valor valido.");
				        }
				    } catch (NumberFormatException e) {
				        System.out.println("Error: La edad debe ser un entero entre 0 y 150. Intente nuevamente.");
				    }
				} while (edad == null || edad < 0 || edad >= 150);


				// Crear objeto Cliente
				cliente = new Cliente(nombre, fechaNacimiento, run, rutCliente, nombres, apellidos, telefono, afp,
						sistemaSalud, direccion, comuna, edad);
				contenedor.almacenarCliente(cliente);
				System.out.println("\nCliente almacenado exitosamente.");
				break;

			// case 2: Almacenar Profesional
			case 2:
				do {
					System.out.print("\nIngrese nombres y apellidos del profesional (entre 10 y 50 caracteres): ");
					nombre = scanner.nextLine();

					if (nombre.length() < 10 || nombre.length() > 50) {
						System.out.println("El nombre debe tener entre 10 y 50 caracteres.");
					}
				} while (nombre.isEmpty() || nombre.length() < 10 || nombre.length() > 50);

				do {
					System.out.print("Ingrese la fecha de nacimiento del profesional (formato: dd-mm-aaaa): ");
					String fechaNacimientoStr = scanner.nextLine();
					DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
					try {
						fechaNacimiento = LocalDate.parse(fechaNacimientoStr, formatter);
						break;
					} catch (DateTimeParseException e) {
						System.out.println("Error: Fecha de nacimiento en formato invalido.");
					}
				} while (true);

				run = null;
				do {
				    System.out.print("Run (sin puntos ni guion ni digito verificador): ");
				    String runStr = scanner.nextLine();
				    if (runStr.isEmpty()) {
				        System.out.println("Error: Run invalido. Intentelo nuevamente.");
				        continue;
				    }
				    try {
				        run = Integer.parseInt(runStr);
				        if (run < 0 || run > 99999999) {
				            System.out.println("Error: Run invalido. Intentelo nuevamente.");
				        }
				    } catch (NumberFormatException e) {
				        System.out.println("Error: Run invalido. Intentelo nuevamente.");
				    }
				} while (run == null || run < 0 || run > 99999999);

				String titulo;
				do {
					System.out.print("Ingrese el titulo del profesional (entre 10 y 50 caracteres): ");
					titulo = scanner.nextLine();
					if (titulo != null && !titulo.isEmpty() && titulo.length() >= 10 && titulo.length() <= 50) {
						break;
					} else {
						System.out.println("Error: El titulo debe tener entre 10 y 50 caracteres.");
					}
				} while (true);

				LocalDate fechaIngreso = null;
				do {
					System.out.print("Ingrese la fecha de ingreso del profesional (formato: dd-mm-aaaa): ");
					String fechaIngresoStr = scanner.nextLine();
					DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
					try {
						fechaIngreso = LocalDate.parse(fechaIngresoStr, formatter);
						break;
					} catch (DateTimeParseException e) {
						System.out.println("Error: Fecha de ingreso en formato invalido.");
					}
				} while (true);

				// Crear objeto Profesional
				profesional = new Profesional(nombre, fechaNacimiento, run, titulo, fechaIngreso);
				contenedor.almacenarProfesional(profesional);
				System.out.println("\nProfesional almacenado exitosamente.");
				break;

			// Case 3: Almacenar Administrativo
			case 3:
				System.out
						.print("\nIngrese nombres y apellidos del Administrativo (minimo 10 caracteres, maximo 50): ");
				nombre = scanner.nextLine();

				while (nombre.isEmpty() || nombre.length() < 10 || nombre.length() > 50) {
					System.out.println(
							"El nombre debe tener un minimo de 10 caracteres y un maximo de 50. Ingrese nuevamente.");
					nombre = scanner.nextLine();
				}

				do {
					System.out.print("Ingrese la fecha de nacimiento del administrativo (formato: dd-mm-aaaa): ");
					String fechaNacimientoStr = scanner.nextLine();
					DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
					try {
						fechaNacimiento = LocalDate.parse(fechaNacimientoStr, formatter);
						break;
					} catch (DateTimeParseException e) {
						System.out.println("Error: Fecha de nacimiento en formato invalido.");
					}
				} while (true);

				run = null;
				do {
				    System.out.print("Run (sin puntos ni guion ni digito verificador): ");
				    String runStr = scanner.nextLine();
				    if (runStr.isEmpty()) {
				        System.out.println("Error: Run invalido. Intentelo nuevamente.");
				        continue;
				    }
				    try {
				        run = Integer.parseInt(runStr);
				        if (run < 0 || run > 99999999) {
				            System.out.println("Error: Run invalido. Intentelo nuevamente.");
				        }
				    } catch (NumberFormatException e) {
				        System.out.println("Error: Run invalido. Intentelo nuevamente.");
				    }
				} while (run == null || run < 0 || run > 99999999);
				
				String area;
				do {
					System.out.print("Ingrese el area del administrativo (entre 5 y 20 caracteres): ");
					area = scanner.nextLine();
					if (area != null && !area.isEmpty() && area.length() >= 5 && area.length() <= 20) {
						break;
					} else {
						System.out.println("Error: El area debe tener entre 5 y 20 caracteres.");
					}
				} while (true);

				String experienciaPrevia;
				do {
					System.out.print("Ingrese la experiencia previa del administrativo (maximo 100 caracteres): ");
					experienciaPrevia = scanner.nextLine();

					if (experienciaPrevia.length() > 0 && experienciaPrevia.length() <= 100) {
						break;
					} else {
						System.out.println(
								"Error: La experiencia previa es obligatoria y debe tener menos de 100 caracteres.");
					}
				} while (true);

				// Crear objeto Administrativo
				administrativo = new Administrativo(nombre, fechaNacimiento, run, area, experienciaPrevia);
				contenedor.almacenarAdministrativo(administrativo);
				System.out.println("\nAdministrativo almacenado exitosamente.");
				break;

			// Case 4: Almacenar Capacitación
			case 4:
				int identificador;
				scanner.nextLine(); // Consumir el salto de línea pendiente antes del case 4
				do {
					System.out.print("\nIngrese el identificador de la capacitacion: ");
					String identificadorStr = scanner.nextLine();
					try {
						identificador = Integer.parseInt(identificadorStr);
						break;
					} catch (NumberFormatException e) {
						System.out.println("Error: Ingrese un numero entero.");
					}
				} while (true);

				boolean clienteExistente = false;

				do {
					System.out.print("Ingrese el RUT del cliente (sin puntos ni guion ni digito verificador): ");
					rutCliente = scanner.nextInt();
					scanner.nextLine(); // Consumir el salto de línea pendiente

					clienteExistente = false; // Reiniciar la variable clienteExistente en cada iteración

					// Verificar si el rutCliente está almacenado previamente
					for (IAsesoria asesoria : contenedor.asesorias) {
						if (asesoria instanceof Cliente && ((Cliente) asesoria).getRutCliente() == rutCliente) {
							clienteExistente = true;
							break;
						}
					}

					if (!clienteExistente) {
						System.out.println("Error: El RUT del cliente no se encuentra almacenado.");
					}
				} while (rutCliente >= 99999999 || !clienteExistente);

				String dia;
				do {
					System.out.print(
							"Ingrese el dia de la capacitacion (Lunes, Martes, Miercoles, Jueves, Viernes, Sabado, Domingo): ");
					dia = scanner.nextLine();
					Capacitacion capacitacion = new Capacitacion();
					if (capacitacion.isValidDia(dia)) {
						break;
					} else {
						System.out.println("Error: Dia invalido. Debe ser un dia entre Lunes y Domingo.");
					}
				} while (true);

				LocalTime hora = null;
				do {
					System.out.print("Ingrese la hora de la capacitacion (formato: HH:mm): ");
					String horaStr = scanner.nextLine();
					DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
					try {
						hora = LocalTime.parse(horaStr, formatter);
						break;
					} catch (DateTimeParseException e) {
						System.out.println("Error: Hora en formato invalido.");
					}
				} while (true);

				String lugar;
				do {
					System.out.print("Ingrese el lugar de la capacitacion (entre 10 y 50 caracteres): ");
					lugar = scanner.nextLine();
					if (lugar != null && !lugar.isEmpty() && lugar.length() >= 10 && lugar.length() <= 50) {
						break;
					} else {
						System.out.println("Error: El lugar debe tener entre 10 y 50 caracteres.");
					}
				} while (true);

				String duracion;
				do {
					System.out.print("Ingrese la duracion de la capacitacion (cantidad de minutos): ");
					duracion = scanner.nextLine();
					if (duracion != null && !duracion.isEmpty() && duracion.length() <= 70) {
						break;
					} else {
						System.out.println("Error: La duracion debe tener un maximo de 70 caracteres.");
					}
				} while (true);

				int cantidad;
				do {
					System.out.print("Ingrese la cantidad de asistentes a la capacitacion (maximo 1000): ");
					String cantidadStr = scanner.nextLine();
					try {
						cantidad = Integer.parseInt(cantidadStr);
						if (cantidad > 0 && cantidad <= 1000) {
							break;
						} else {
							System.out.println("Error: Cantidad invalida. Debe ser un numero entre 1 y 1000.");
						}
					} catch (NumberFormatException e) {
						System.out.println("Error: Cantidad invalida. Ingrese un numero entero.");
					}
				} while (true);

				// Crear objeto Capacitacion
				Capacitacion capacitacion = new Capacitacion(identificador, rutCliente, dia, hora, lugar, duracion,
						cantidad, cliente);
				contenedor.almacenarCapacitacion(capacitacion);
				System.out.println("\nCapacitacion almacenada exitosamente.");
				break;

			// Case 5: Eliminar Usuario buscándolo por su RUN
			case 5:
				int runEliminar;
				boolean usuarioEncontrado = false;
				do {
				    System.out.print("\nIngrese el RUN del usuario a eliminar (sin puntos ni guion): ");
				    String runEliminarStr = scanner.nextLine();
				    try {
				        runEliminar = Integer.parseInt(runEliminarStr);
				        usuarioEncontrado = contenedor.eliminarUsuario(runEliminar);
				        if (!usuarioEncontrado) {
				            System.out.println("Error: RUN no encontrado. Intente nuevamente.");
				        }
				    } catch (NumberFormatException e) {
				        System.out.println("Error: RUN no encontrado. Intente nuevamente.");
				    }
				} while (!usuarioEncontrado);

				System.out.println("\nUsuario eliminado exitosamente.");
				break;

			// Case 6: Listar Usuarios
			case 6:
				System.out.println("\nListado de Usuarios:");
				contenedor.listarUsuarios();
				System.out.println();
				break;

			// Case 7: Listar Usuarios por tipo
			case 7:
				System.out.println("\nListado de Usuarios por tipo:");
				System.out.println("\nListado de Clientes:");
				contenedor.listarUsuariosPorTipo("cliente");
				System.out.println();

				System.out.println("\nListado de Profesionales:");
				contenedor.listarUsuariosPorTipo("profesional");
				System.out.println();

				System.out.println("\nListado de Administrativos:");
				contenedor.listarUsuariosPorTipo("administrativo");
				System.out.println();
				break;

			// case 8: Listar Capacitaciones
			case 8:
				System.out.println("\nListado de Capacitaciones:");
				contenedor.listarCapacitaciones();
				break;

			// Case 9: Salir del Programa
			case 9:
				System.out.println("\nHasta luego!");
				break;
			default:
				System.out.println("Opcion incorrecta. Por favor, ingrese nuevamente.");
				break;
			}

		} while (opcion != 9);

		scanner.close();
	}
}
