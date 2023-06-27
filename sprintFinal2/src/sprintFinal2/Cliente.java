package sprintFinal2;

import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;

/**
 * Clase que representa un Cliente, que es un tipo de Usuario y puede brindar Asesoría.
 */

public class Cliente extends Usuario implements Asesoria {
    private String apellido;
    private String telefono;
    private String afp;
    private int sistemaSalud;
    private String direccion;
    private String comuna;
    private int edad;
    //private List<VisitaEnTerreno> visitas;

    /**
     * Constructor vacío de la clase Cliente.
     */
    
    public Cliente() {}
    
    /**
     * Constructor de la clase Cliente.
     *
     * @param nombres         Nombres del cliente.
     * @param apellidos       Apellidos del cliente.
     * @param rut             Rut del cliente.
     * @param telefono        Teléfono del cliente.
     * @param afp             AFP del cliente.
     * @param sistemaSalud    Sistema de salud del cliente.
     * @param direccion       Dirección del cliente.
     * @param comuna          Comuna del cliente.
     * @param edad            Edad del cliente.
     */

    public Cliente(String nombre, String apellido, int run, LocalDate fechaNacimiento, String email, String telefono, String afp, int sistemaSalud, String direccion, String comuna, int edad) {
    	super(nombre, run , fechaNacimiento , email);
        this.apellido = apellido;
        this.telefono = telefono;
        this.afp = afp;
        this.sistemaSalud = sistemaSalud;
        this.direccion = direccion;
        this.comuna = comuna;
        this.edad = edad;
        //this.visitas = new ArrayList<>();
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        if (apellido.length() >= 5 && apellido.length() <= 30) {
            this.apellido = apellido;
        } else {
            System.out.println("Los apellidos deben tener entre 5 y 30 caracteres.");
        }
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getAfp() {
        return afp;
    }

    public void setAfp(String afp) {
        if (afp.length() >= 4 && afp.length() <= 30) {
            this.afp = afp;
        } else {
            System.out.println("La AFP debe tener entre 4 y 30 caracteres.");
        }
    }

    public int getSistemaSalud() {
        return sistemaSalud;
    }

    public void setSistemaSalud(int nombreSistemaSalud) {
        if (nombreSistemaSalud == 1 || nombreSistemaSalud == 2) {
            this.sistemaSalud = nombreSistemaSalud;
        } else {
            System.out.println("El sistema de salud debe ser 1 (Fonasa) o 2 (Isapre).");
        }
    }    
   

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        if (direccion.length() <= 70) {
            this.direccion = direccion;
        } else {
            System.out.println("La direccion no puede tener mas de 70 caracteres.");
        }
    }

    public String getComuna() {
        return comuna;
    }

    public void setComuna(String comuna) {
        if (comuna.length() <= 50) {
            this.comuna = comuna;
        } else {
            System.out.println("La comuna no puede tener mas de 50 caracteres.");
        }
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        if (edad >= 0 && edad < 150) {
            this.edad = edad;
        } else {
            System.out.println("La edad debe ser mayor o igual a cero y menor a 150.");
        }
    }

    public String toString() {
        return super.toString() + " , Apellidos: " + apellido + " , Telefono: " + telefono + " , AFP: " + afp + " , Sistema de salud: " + sistemaSalud + " , Direccion: " + direccion + " , Comuna: " + comuna + " , Edad: " + edad;
    }
    
    public String obtenerSistemaSalud() {
        if (sistemaSalud == 1) {
            return "Fonasa";
        } else if (sistemaSalud == 2) {
            return "Isapre";
        } else {
            return "Sistema de salud no definido";
        }
    }

    public String obtenerNombre() {
        return getNombre() + " " + getApellido();
    }

    public void analizarUsuario() {
        super.analizarUsuario();
        System.out.println("Direccion: " + direccion + " , Comuna: " + comuna);
    }
    
    private List<Capacitacion> capacitaciones;

    public List<Capacitacion> getCapacitaciones() {
        return capacitaciones;
    }

    public void setCapacitaciones(List<Capacitacion> capacitaciones) {
        this.capacitaciones = capacitaciones;
    }

    public String getNombreCompleto() {
        return getNombre() + " " + getApellido();
    }

	@Override
	public void listarUsuario() {
		// TODO Auto-generated method stub
		
	}

	/*public void agregarVisita(VisitaEnTerreno visita) {
        visitas.add(visita);
    }*/

	

	
}
