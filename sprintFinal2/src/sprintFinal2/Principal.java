package sprintFinal2;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;




public class Principal {
    public static void main(String[] args) {
    	
        Contenedor contenedor = new Contenedor();
        Scanner scanner = new Scanner(System.in);
        boolean salir = false;
        int opcion;
        
        System.out.println("Bienvenido al sistema de registro HERM");
        
        while(!salir) {
        	
        
            System.out.println("=== MENU PRINCIPAL ===");
            System.out.println("1. Almacenar cliente");
            System.out.println("2. Almacenar profesional");
            System.out.println("3. Almacenar administrativo");
            System.out.println("4. Almacenar capacitacion");
            System.out.println("5. Eliminar usuario");
            System.out.println("6. Listar usuarios");
            System.out.println("7. Listar usuarios por tipo");
            System.out.println("8. Listar capacitaciones");
            System.out.println("9. Salir");
            
        try{
        	
            System.out.print("Ingrese una opcion: ");            
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    almacenarCliente(contenedor, scanner);
                    break;
                case 2:
                    almacenarProfesional(contenedor, scanner);
                    break;
                case 3:
                    almacenarAdministrativo(contenedor, scanner);
                    break;
                case 4:
                    almacenarCapacitacion(contenedor, scanner);
                    break;
                case 5:
                    eliminarUsuario(contenedor, scanner);
                    break;
                case 6:
                    listarUsuarios(contenedor);
                    break;
                case 7:
                    listarUsuariosPorTipo(contenedor);
                    break;
                case 8:
                    listarCapacitaciones(contenedor);
                    break;
                case 9:
                    System.out.println("¡Hasta pronto!, que tenga un excelente dia");
                    salir = true;
                    break;
                default:
                    System.out.println("Opcion invalida, intente nuevamente.");
            }
        }
          //Si el usuario ingresa un caracter entrega el siguiente mensaje
		catch(InputMismatchException | NumberFormatException e){
				System.out.println("Debes seleccionar un numero de las opciones indicadas");
			}

			//Pausa en la ejecución del programa
			System.out.println("\n\t\t---Pulse ENTER para continuar---");
			scanner.nextLine();
        }}

    private static void almacenarCliente(Contenedor contenedor, Scanner scanner) {
    	    	
    	int run = 0;
    	while (run <= 0 || run >= 1000000000) {
    	    System.out.print("Ingrese el RUT del cliente: ");
    	    run = scanner.nextInt();
    	    if (run <= 0 || run >= 1000000000 || Verificar.verificarRut(run)) {
    	        System.out.println("El RUT debe ser mayor que cero y menor que 999999999.");
    	    }
    	}
    	
    	scanner.nextLine(); // Agregar esta línea para limpiar el búfer de entrada

    	String nombre = "";
    	while (nombre.isEmpty()) {
    	    System.out.print("Ingrese los 2 nombres del cliente: ");
    	    nombre = scanner.nextLine();
    	    if (nombre.isEmpty()) {
    	        System.out.println("El nombre no puede estar vacio.");
    	    }
    	  }
    	String apellido = "";
    	while (apellido.isEmpty()) {
    	    System.out.print("Ingrese los 2 apellidos del cliente: ");
    	    apellido = scanner.nextLine();
    	    if (apellido.isEmpty()) {
    	        System.out.println("El apellido no puede estar vacio.");
    	    }
    	}
    	LocalDate fechaNacimiento = null;
    	while (fechaNacimiento == null) {
    	    try {
    	        System.out.print("Ingrese la fecha de nacimiento del profesional (formato yyyy-MM-dd): ");
    	        fechaNacimiento = LocalDate.parse(scanner.nextLine());
    	    } catch (DateTimeParseException e) {
    	        System.out.println("Formato de fecha incorrecto. Ingrese la fecha en formato yyyy-MM-dd.");
    	    }
    	}
    	String telefono = "";
    	while (telefono.isEmpty()) {
    	    System.out.print("Ingrese el telefono del cliente: ");
    	    telefono = scanner.nextLine();
    	    if (telefono.isEmpty()) {
    	        System.out.println("El telefono no puede estar vacio.");
    	    }
    	}
    	String afp = "";
    	while (afp.isEmpty()) {
    	    System.out.print("Ingrese la AFP del cliente: ");
    	    afp = scanner.nextLine();
    	    if (afp.isEmpty()) {
    	        System.out.println("La AFP no puede estar vacia.");
    	    }
    	}
        int sistemaSalud = 0;
        while (sistemaSalud != 1 && sistemaSalud != 2) {
            System.out.print("Ingrese el sistema de salud del cliente (1: FONASA, 2: ISAPRE): ");
            sistemaSalud = scanner.nextInt();
            scanner.nextLine();
            if (sistemaSalud != 1 && sistemaSalud != 2) {
                System.out.println("Opcion invalida, ingrese 1 o 2");
            }
        }
        
    	
        System.out.print("Ingrese la direccion del cliente: ");
        String direccion = scanner.nextLine();
        while (direccion.isEmpty()) {
            System.out.print("La direccion no puede estar vacia. Ingrese la direccion del cliente: ");
            direccion = scanner.nextLine();
        }
        System.out.print("Ingrese la comuna del cliente: ");
        String comuna = scanner.nextLine();
        while (comuna.isEmpty()) {
            System.out.print("La comuna no puede estar vacia. Ingrese la comuna del cliente: ");
            comuna = scanner.nextLine();
        }
        int edad = 0;
        while (edad <= 0 || edad >= 150) {
            System.out.print("Ingrese la edad del cliente: ");
            edad = scanner.nextInt();
            scanner.nextLine();
            if (edad <= 0) {
                System.out.println("La edad debe ser mayor a cero.");
            }
        }
        
        Cliente cliente = new Cliente();
        cliente.setNombre(nombre);
        cliente.setApellido(apellido);
        cliente.setRun(run);
        cliente.setFechaNacimiento(fechaNacimiento);
        cliente.setTelefono(telefono);
        cliente.setAfp(afp);
        cliente.setSistemaSalud(sistemaSalud);
        cliente.setDireccion(direccion);
        cliente.setComuna(comuna);
        cliente.setEdad(edad);
        
        
     // Solicitar información de la visita en terreno
       /* System.out.println("Ingrese numero identificador de la visita en terreno:");
        int identificadorVisita = scanner.nextInt();
        LocalDate dia = null;
        while (dia == null) {
        	try {
            System.out.print("Ingrese la fecha de la visita en terreno en (formato yyyy-MM-dd) ");            
                dia = LocalDate.parse(scanner.nextLine());
                if (dia.isAfter(LocalDate.now())) {
                    System.out.println("La fecha de la visita en terreno no puede ser posterior a la fecha actual.");
                    dia = null;
                }
            } catch (DateTimeParseException e) {
                System.out.println("La fecha de la visita en terreno debe estar en (formato yyyy-MM-dd)");
            }
        }
        
        scanner.nextLine(); // Limpiar el búfer de entrada
        String hora = "";
        while (hora.isEmpty()) {
            System.out.print("Ingrese la hora de la visita en terreno: ");
            hora = scanner.nextLine();
            if (hora.isEmpty()) {
                System.out.println("La hora no puede estar vacía.");
            }
        }
        String lugar = "";
        while (lugar.isEmpty()) {
            System.out.print("Ingrese el lugar de la visita en terreno: ");
            lugar = scanner.nextLine();
            if (lugar.isEmpty()) {
                System.out.println("El lugar no puede estar vacío.");
            }
        }
        String comentariosVisita = "";
        while (comentariosVisita.isEmpty()) {
            System.out.print("Ingrese los comentarios de la visita en terreno: ");
            comentariosVisita = scanner.nextLine();
            if (comentariosVisita.isEmpty()) {
                System.out.println("Los comentarios no pueden estar vacíos.");
            }
        }

        // Crear instancia de VisitaEnTerreno y agregarla al cliente
        VisitaEnTerreno visitaEnTerreno = new VisitaEnTerreno();
        visitaEnTerreno.setIdentificador(identificadorVisita);
        visitaEnTerreno.setDia(dia);
        visitaEnTerreno.setHora(hora);
        visitaEnTerreno.setLugar(lugar);
        visitaEnTerreno.setComentarios(comentariosVisita);
        cliente.agregarVisita(visitaEnTerreno);

        // Solicitar información de la revisión
        System.out.println("Ingrese información de la revisión:");
        int identificadorRevision = scanner.nextInt();
        scanner.nextLine(); // Limpiar el búfer de entrada
        String nombreRevision = "";
        while (nombreRevision.isEmpty()) {
            System.out.print("Ingrese el nombre de la revisión: ");
            nombreRevision = scanner.nextLine();
            if (nombreRevision.isEmpty()) {
                System.out.println("El nombre no puede estar vacío.");
            }
        }
        String detalleRevision = "";
        while (detalleRevision.isEmpty()) {
            System.out.print("Ingrese el detalle de la revisión: ");
            detalleRevision = scanner.nextLine();
            if (detalleRevision.isEmpty()) {
                System.out.println("El detalle no puede estar vacío.");
            }
        }
        int estadoRevision = 0;
        while (estadoRevision <= 0 || estadoRevision > 3) {
            System.out.print("Ingrese el estado de la revisión (1 para pendiente, 2 para en proceso, 3 para completada): ");
            estadoRevision = scanner.nextInt();
            if (estadoRevision <= 0 || estadoRevision > 3) {
                System.out.println("El estado debe ser 1, 2 o 3.");
            }
        }

        // Crear instancia de Revision y agregarla a la visita en terreno
        Revision revision = new Revision();
        revision.setIdentificador(identificadorRevision);
        revision.setIdentificadorVisita(identificadorVisita);
        revision.setNombre(nombreRevision);
        revision.setDetalle(detalleRevision);
        revision.setEstado(estadoRevision);
        visitaEnTerreno.agregarRevision(revision);

     // Agregar visita en terreno al cliente y almacenar cliente en contenedor
        cliente.agregarVisita(visitaEnTerreno);
        
     // Preguntar si desea agregar más visitas en terreno y revisiones
        boolean agregarMasVisitas = false;
        boolean agregarMasRevisiones = false;
        while (true) {
            System.out.print("¿Desea agregar más visitas en terreno a este cliente? (s/n): ");
            String respuesta = scanner.nextLine();
            if (respuesta.equalsIgnoreCase("s")) {
                agregarMasVisitas = true;
                break;
            } else if (respuesta.equalsIgnoreCase("n")) {
                break;
            } else {
                System.out.println("Por favor, ingrese 's' para si o 'n' para no.");
            }
        }
        if (agregarMasVisitas) {
            while (true) {
                System.out.println("Ingrese información de la nueva visita en terreno:");
                identificadorVisita = scanner.nextInt();
                LocalDate dia2 = null;
                while (dia2 == null) {
                	try {
                    System.out.print("Ingrese la fecha de la visita en terreno en (formato yyyy-MM-dd): ");                    
                        dia2 = LocalDate.parse(scanner.nextLine());
                        if (dia2.isAfter(LocalDate.now())) {
                            System.out.println("La fecha de la visita en terreno no puede ser posterior a la fecha actual.");
                            dia2 = null;
                        }
                    } catch (DateTimeParseException e) {
                        System.out.println("La fecha de la visita en terreno debe estar en formato yyyy-MM-dd.");
                    }
                }
                
                hora = "";
                while (hora.isEmpty()) {
                    System.out.print("Ingrese la hora de la visita en terreno: ");
                    hora = scanner.nextLine();
                    if (hora.isEmpty()) {
                        System.out.println("La hora no puede estar vacía.");
                    }
                }
                lugar = "";
                while (lugar.isEmpty()) {
                    System.out.print("Ingrese el lugar de la visita en terreno: ");
                    lugar = scanner.nextLine();
                    if (lugar.isEmpty()) {
                        System.out.println("El lugar no puede estar vacío.");
                    }
                }
                comentariosVisita = "";
                while (comentariosVisita.isEmpty()) {
                    System.out.print("Ingrese comentarios sobre la visita en terreno: ");
                    comentariosVisita = scanner.nextLine();
                    if (comentariosVisita.isEmpty()) {
                        System.out.println("Los comentarios no pueden estar vacíos.");
                    }
                }
                visitaEnTerreno = new VisitaEnTerreno();
                visitaEnTerreno.setIdentificador(identificadorVisita);
                visitaEnTerreno.setDia(dia2);
                visitaEnTerreno.setHora(hora);
                visitaEnTerreno.setLugar(lugar);
                visitaEnTerreno.setComentarios(comentariosVisita);
                cliente.agregarVisita(visitaEnTerreno);

                // Agregar revisión a la nueva visita
                System.out.println("Ingrese información de la revisión:");
                int identificadorRevision2 = scanner.nextInt();
                scanner.nextLine(); // Limpiar el búfer de entrada
                String nombreRevision2 = "";
                while (nombreRevision.isEmpty()) {
                    System.out.print("Ingrese el nombre de la revisión: ");
                    nombreRevision = scanner.nextLine();
                    if (nombreRevision.isEmpty()) {
                        System.out.println("El nombre no puede estar vacío.");
                    }
                }
                String detalleRevision2 = "";
                while (detalleRevision.isEmpty()) {
                    System.out.print("Ingrese el detalle de la revisión: ");
                    detalleRevision = scanner.nextLine();
                    if (detalleRevision.isEmpty()) {
                        System.out.println("El detalle no puede estar vacío.");
                    }
                }
                int estadoRevision2 = 0;
                while (estadoRevision <= 0 || estadoRevision > 3) {
                    System.out.print("Ingrese el estado de la revisión (1 para pendiente, 2 para en proceso, 3 para completada): ");
                    estadoRevision = scanner.nextInt();
                    if (estadoRevision <= 0 || estadoRevision > 3) {
                        System.out.println("El estado debe ser 1, 2 o 3.");
                    }
                }
                revision = new Revision();
                revision.setIdentificador(identificadorRevision2);
                revision.setIdentificadorVisita(identificadorVisita);
                revision.setNombre(nombreRevision2);
                revision.setDetalle(detalleRevision2);
                revision.setEstado(estadoRevision2);
                visitaEnTerreno.agregarRevision(revision);

                // Preguntar si desea agregar más revisiones a la nueva visita
                agregarMasRevisiones = false;
                while (true) {
                    System.out.print("¿Desea agregar más revisiones a esta visita? (s/n): ");
                    String respuesta = scanner.nextLine();
                    if (respuesta.equalsIgnoreCase("s")) {
                        agregarMasRevisiones = true;
                        break;
                    } else if (respuesta.equalsIgnoreCase("n")) {
                        break;
                    } else {
                        System.out.println("Por favor, ingrese 's' para sí o 'n' para no.");
                    }
                }
                if (!agregarMasRevisiones) {
                    break;
                }
            }
        }   */

        contenedor.almacenarCliente(cliente);
        
        System.out.println("Cliente almacenado exitosamente.");
    }


    private static void almacenarProfesional(Contenedor contenedor, Scanner scanner) {
    	
    	int run = 0;
    	while (run <= 0 || run >= 1000000000) {
    	    System.out.print("Ingrese el RUT del profesional: ");
    	    run = scanner.nextInt();
    	    if (run <= 0 || run >= 1000000000 || Verificar.verificarRut(run)) {
    	        System.out.println("El RUT debe ser mayor que cero y menor que 999999999.");
    	    }
    	}
    	
    	scanner.nextLine(); // Agregar esta línea para limpiar el búfer de entrada

    	String nombre = "";
    	while (nombre.isEmpty()) {
    	    System.out.print("Ingrese el nombre del profesional: ");
    	    nombre = scanner.nextLine();
    	    if (nombre.isEmpty()) {
    	        System.out.println("El nombre no puede estar vacio.");
    	    }
    	  }
    	LocalDate fechaNacimiento = null;
    	while (fechaNacimiento == null) {
    	    try {
    	        System.out.print("Ingrese la fecha de nacimiento del profesional (formato yyyy-MM-dd): ");
    	        fechaNacimiento = LocalDate.parse(scanner.nextLine());
    	    } catch (DateTimeParseException e) {
    	        System.out.println("Formato de fecha incorrecto. Ingrese la fecha en formato yyyy-MM-dd.");
    	    }
    	}
    	String correo = "";
    	while (correo.isEmpty()) {
    	    System.out.print("Ingrese el correo electrónico del profesional: ");
    	    correo = scanner.nextLine();
    	    if (correo.isEmpty()) {
    	        System.out.println("El correo electrónico no puede estar vacio.");
    	    }
    	}
    	String titulo = "";
    	while (titulo.isEmpty()) {
    	    System.out.print("Ingrese el título del profesional: ");
    	    titulo = scanner.nextLine();
    	    if (titulo.isEmpty()) {
    	        System.out.println("El título no puede estar vacio.");
    	    }
    	}
    	String especialidad = "";
    	while (especialidad.isEmpty()) {
    	    System.out.print("Ingrese la especialidad del profesional: ");
    	    especialidad = scanner.nextLine();
    	    if (especialidad.isEmpty()) {
    	        System.out.println("La especialidad no puede estar vacia.");
    	    }
    	}
    	LocalDate fechaIngreso = null;
    	while (fechaIngreso == null) {
    	    try {
    	        System.out.print("Ingrese la fecha de ingreso del profesional (formato yyyy-MM-dd): ");
    	        fechaIngreso = LocalDate.parse(scanner.nextLine());
    	    } catch (DateTimeParseException e) {
    	        System.out.println("Formato de fecha incorrecto. Ingrese la fecha en formato yyyy-MM-dd.");
    	    }
    	}
    	Profesional profesional = new Profesional();
    	profesional.setNombre(nombre);
    	profesional.setRun(run);
    	profesional.setEmail(correo);
    	profesional.setFechaNacimiento(fechaNacimiento);
    	profesional.setTitulo(titulo);
    	profesional.setFechaIngreso(fechaIngreso);
    	
        contenedor.almacenarProfesional(profesional);
        
        System.out.println("Profesional almacenado exitosamente.");
    }
    

    private static void almacenarAdministrativo(Contenedor contenedor, Scanner scanner) {
    	
    	int run = 0;
    	while (run <= 0 || run >= 1000000000) {
    	    System.out.print("Ingrese el RUT del administrativo: ");
    	    run = scanner.nextInt();
    	    if (run <= 0 || run >= 1000000000 || Verificar.verificarRut(run)) {
    	        System.out.println("El RUT debe ser mayor que cero y menor que 999999999.");
    	    }
    	}
    	
    	scanner.nextLine(); // Agregar esta línea para limpiar el búfer de entrada

    	String nombre = "";
    	while (nombre.isEmpty()) {
    	    System.out.print("Ingrese el nombre del administrativo: ");
    	    nombre = scanner.nextLine();
    	    if (nombre.isEmpty()) {
    	        System.out.println("El nombre no puede estar vacio.");
    	    }
    	  }
        String correo = "";
        while (correo.isEmpty()) {
            System.out.print("Ingrese el correo electrónico del administrativo: ");
            correo = scanner.nextLine();
            if (correo.isEmpty()) {
                System.out.println("El correo electrónico no puede estar vacio.");
            }
        }
        LocalDate fechaNacimiento = null;
        while (fechaNacimiento == null) {
            try {
                System.out.print("Ingrese la fecha de nacimiento del administrativo (formato yyyy-MM-dd): ");
                fechaNacimiento = LocalDate.parse(scanner.nextLine());
            } catch (DateTimeParseException e) {
                System.out.println("Formato de fecha incorrecto. Ingrese la fecha en formato yyyy-MM-dd.");
            }
        }
        String area = "";
        while (area.isEmpty()) {
            System.out.print("Ingrese el área del administrativo: ");
            area = scanner.nextLine();
            if (area.isEmpty()) {
                System.out.println("El área no puede estar vacia.");
            }
        }
        String experienciaPrevia = "";
        while (experienciaPrevia.isEmpty()) {
            System.out.print("Ingrese la experiencia previa del administrativo: ");
            experienciaPrevia = scanner.nextLine();
            if (experienciaPrevia.isEmpty()) {
                System.out.println("La experiencia previa no puede estar vacia.");
            }
        }
        Administrativo administrativo = new Administrativo();
        administrativo.setNombre(nombre);
        administrativo.setRun(run);
        administrativo.setEmail(correo);
        administrativo.setFechaNacimiento(fechaNacimiento);
        administrativo.setArea(area);
        administrativo.setExperienciaPrevia(experienciaPrevia);
        
        contenedor.almacenarAdministrativo(administrativo);
        
        System.out.println("Administrativo almacenado exitosamente.");
    }


    private static void almacenarCapacitacion(Contenedor contenedor, Scanner scanner) {
    	int identificador = 0;
    	while (identificador <= 0) {
    	    System.out.print("Ingrese el identificador de la capacitacion: ");
    	    identificador = scanner.nextInt();
    	    scanner.nextLine();
    	    if (identificador <= 0) {
    	        System.out.println("El identificador debe ser mayor que cero.");
    	    }
    	}
    	String run = "";
    	while (run.isEmpty() || !run.matches("[0-9]{1,9}")) {
    	    System.out.print("Ingrese el RUT del cliente: ");
    	    run = scanner.nextLine();
    	    if (run.isEmpty() || Integer.parseInt(run) < 0 || Integer.parseInt(run) > 999999999) {
    	        System.out.println("El RUT debe ser mayor que cero y menor que 999999999.");
    	        run = "";
    	    }
    	}
    	String dia = "";
    	
    	
    	while (true) {
			System.out.println("ingrese dia de la semana de la capacitacion debe de ser entre lunes a domingo:");
			dia= scanner.nextLine();
			if(!dia.isEmpty() && Verificar.verificarDia(dia)) {
				
				dia = dia.substring(0, 1).toUpperCase() + dia.substring(1).toLowerCase();

				break;
			}else {
				System.out.println("\n\t-- Debe de ingresar un dia valido");
			}
		}
        String hora = "";
        
        
        
        while (true ) {
			System.out.println("Ingrese la hora de la capacitacion, debe de estar en formato HH:MM :");
			hora = scanner.nextLine();
			if(!hora.isEmpty() && Verificar.verificarHora(hora)) {
				break;
			}else {
				System.out.println("\n\t-- Ingrese una hora en formato correcto");
			}
		}
        
        String lugar = "";
       
        while(true) {
			System.out.println("Ingrese el lugar de la capacitacion, debe de ser entre 10 y 50 caracteres: ");
			lugar = scanner.nextLine();
			if(!lugar.isEmpty() && Verificar.verificarNombre(lugar)) {
				break;
			}else {
				System.out.println("\n\t-- Ingrese un lugar entre 10 y 50 caracteres");
			}
		}
        
        int duracion = 0;
        while (duracion <= 0) {
            System.out.print("Ingrese la duración de la capacitacion (en horas): ");
            duracion = scanner.nextInt();
            scanner.nextLine();
            if (duracion <= 0) {
                System.out.println("La duración debe ser mayor que cero.");
            }
        }
        
        int cantidadAsistentes = 0;
        
        
        
        while (true) {    
		    System.out.print("Ingrese la cantidad de asistentes: ");
		    String cantidad = scanner.nextLine();
		    
		    if (cantidad.isEmpty()) {
		        System.out.println("\n\t-- Debe ingresar un valor.");
		    } else {
		        try {
		            cantidadAsistentes = Integer.parseInt(cantidad);
		            
		            if (cantidadAsistentes <= 10000 && Verificar.verificarNumeros(cantidadAsistentes)) {
		                break;
		            } else {
		                System.out.println("\n\t--Ingrese una cantidad valida menor a 1000.");
		            }
		        } catch (NumberFormatException e) {
		            System.out.println("\n\t-- Debe ingresar un numero valido.");
		        }
		    }
		}
        
        Capacitacion capacitacion = new Capacitacion();
        capacitacion.setIdentificador(identificador);
        capacitacion.setRutCliente(run);
        capacitacion.setDia(dia);
        capacitacion.setHora(hora);
        capacitacion.setLugar(lugar);
        capacitacion.setDuracion(duracion);
        capacitacion.setCantidadAsistentes(cantidadAsistentes);
        
        contenedor.almacenarCapacitacion(capacitacion);
        
        System.out.println("Capacitacion almacenada exitosamente.");
    }
   

    
    
    public static void eliminarUsuario(Contenedor contenedor, Scanner scanner) {
		int run;
		if (contenedor.asesorias.isEmpty() ) {
	        System.out.println("\n\t-- No existen usuarios registrados. ");
	        return;
	    }    			
		
		System.out.print("Ingrese el rut del usuario que desee eliminar, sin punto ni guion: ");
		run = Integer.parseInt(scanner.nextLine());
		if(run<99999999 && Verificar.verificarRut(run)) {
			contenedor.eliminarUsuario(run);	 	               
		}         				
	}

    private static void listarUsuarios(Contenedor contenedor) {
    	if (contenedor.asesorias.isEmpty() ) {
	        System.out.println("\n\t-- No existen usuarios registrados. ");
	        return;
	    }
    	contenedor.listarUsuarios();
    }
    

    private static void listarUsuariosPorTipo(Contenedor contenedor) {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("=== LISTADO DE USUARIOS POR TIPO ===");
            System.out.println("1. Listar clientes");
            System.out.println("2. Listar profesionales");
            System.out.println("3. Listar administrativos");
            System.out.println("4. Volver al menu principal");
            System.out.print("Ingrese una opcion: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    contenedor.listarUsuariosPorTipo("Cliente");
                    break;
                case 2:
                    contenedor.listarUsuariosPorTipo("Profesional");
                    break;
                case 3:
                    contenedor.listarUsuariosPorTipo("Administrativo");
                    break;
                case 4:
                    break;
                default:
                    System.out.println("Opcion invalida, intente nuevamente.");
            }
        } while (opcion != 4);
    }


    private static void listarCapacitaciones(Contenedor contenedor) {
    	
        contenedor.listarCapacitaciones();
    }
}

