package sprintFinal2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;




/**
 * Clase que representa un contenedor para almacenar asesorías y capacitaciones.
 */

public class Contenedor {
	
	Scanner scanner = new Scanner(System.in);
	
    List<Asesoria> asesorias;
    List<Capacitacion> capacitaciones;

    public Contenedor() {
        asesorias = new ArrayList<>();
        capacitaciones = new ArrayList<>();
    }

    public void almacenarCliente(Asesoria cliente) {
        asesorias.add(cliente);
    }

    public void almacenarProfesional(Asesoria profesional) {
        asesorias.add(profesional);
    }

    public void almacenarAdministrativo(Asesoria administrativo) {
        asesorias.add(administrativo);
    }

    public void almacenarCapacitacion(Capacitacion capacitacion) {
        capacitaciones.add(capacitacion);
    }

       
        
    public void eliminarUsuario(int run) {   	
        Iterator<Asesoria> iterator = asesorias.iterator();
        while (iterator.hasNext()) {
            Asesoria asesoria = iterator.next();
            if (asesoria instanceof Usuario && ((Usuario) asesoria).getRun() == run) {
                iterator.remove();
                System.out.println("Usuario con rut " + run + " eliminado correctamente.");
                return; // Salir del método después de eliminar el usuario
            }
        }
        System.out.println("No se encontró ningún usuario con el rut " + run + ".");
    }
    


    public List<Usuario> listarUsuarios() {
        for (Asesoria usuario : asesorias) {
        	
        	usuario.listarUsuario();
            System.out.println(asesorias.toString());
            System.out.println();
        }
		return null;
    }
    
    

    public void listarUsuariosPorTipo(String tipo) {
        for (Asesoria asesoria : asesorias) {
            if (asesoria.getClass().getSimpleName().equalsIgnoreCase(tipo)) {
                System.out.println(asesoria.toString());
            }
        }
    }
    
 
    
    public void listarCapacitaciones() {
        for (Capacitacion capacitacion : capacitaciones) {
            System.out.println(capacitacion.toString());
            System.out.println();
        }
    }
    
    


}
