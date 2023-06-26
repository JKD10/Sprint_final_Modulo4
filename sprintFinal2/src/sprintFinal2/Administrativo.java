package sprintFinal2;

import java.time.LocalDate;
import java.util.List;

/**
 * Clase que representa un Administrativo, que es un tipo de Usuario y puede brindar Asesoría.
 */

public class Administrativo extends Usuario {
    private String area;
    private String experienciaPrevia;
    
    /**
     * Constructor vacío de la clase Administrativo.
     */

    public Administrativo() {}

    /**
     * Constructor de la clase Administrativo.
     *
     * @param nombre              Nombre del administrativo.
     * @param apellido            Apellido del administrativo.
     * @param rut                 Rut del administrativo.
     * @param email               Email del administrativo.
     * @param fechaNacimiento     Fecha de nacimiento del administrativo.
     * @param area                Área del administrativo.
     * @param experienciaPrevia   Experiencia previa del administrativo.
     */
    
    public Administrativo(String nombre, int run, LocalDate fechaNacimiento, String email, String area, String experienciaPrevia) {
        super(nombre, run, fechaNacimiento, email);
        this.area = area;
        this.experienciaPrevia = experienciaPrevia;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        if (area.length() >= 5 && area.length() <= 20) {
            this.area = area;
        } else {
            System.out.println("El area debe tener entre 5 y 20 caracteres.");
        }
    }

    public String getExperienciaPrevia() {
        return experienciaPrevia;
    }

    public void setExperienciaPrevia(String experienciaPrevia) {
        if (experienciaPrevia.length() <= 100) {
            this.experienciaPrevia = experienciaPrevia;
        } else {
            System.out.println("La experiencia previa no debe superar los 100 caracteres.");
        }
    }

    @Override
    public String toString() {
        return "Administrativo [area=" + area + ", experiencia Previa=" + experienciaPrevia + "]";
    }
    
    public void analizarUsuario() {
        super.analizarUsuario();
        System.out.println("Area: " + area);
        System.out.println("Experiencia previa: " + experienciaPrevia);
    }
    
    private List<Capacitacion> capacitaciones;

    public List<Capacitacion> getCapacitaciones() {
        return capacitaciones;
    }

    public void setCapacitaciones(List<Capacitacion> capacitaciones) {
        this.capacitaciones = capacitaciones;
    }

    

	@Override
	public void listarUsuario() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getNombreCompleto() {
		// TODO Auto-generated method stub
		return null;
	}
}

