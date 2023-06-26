package sprintFinal2;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public class Profesional extends Usuario {
    private String titulo;
    private LocalDate fechaIngreso;

    public Profesional() {}

    public Profesional(String nombre, int run, String email, LocalDate fechaNacimiento, String titulo, LocalDate fechaIngreso) {
        super(nombre, run, fechaNacimiento, email);
        this.titulo = titulo;
        this.fechaIngreso = fechaIngreso;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        if (titulo.length() >= 10 && titulo.length() <= 50) {
            this.titulo = titulo;
        } else {
            System.out.println("El titulo debe tener entre 10 y 50 caracteres.");
        }
    }

    public LocalDate getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(LocalDate fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public String toString() {
        return super.toString() + ", Titulo: " + titulo + ", Fecha de ingreso: " + fechaIngreso.toString();
    }
    
    public void analizarUsuario() {
        super.analizarUsuario();
        System.out.println("Título: " + titulo);
        System.out.println("Fecha de ingreso: " + fechaIngreso);
    }

	@Override
	public List<Capacitacion> getCapacitaciones() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getNombreCompleto() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void listarUsuario() {
		// TODO Auto-generated method stub
		
	}
}
