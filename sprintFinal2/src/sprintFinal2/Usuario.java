package sprintFinal2;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public abstract class Usuario implements Asesoria {
    private String nombre;
    private LocalDate fechaNacimiento;
    private int run;
    private String email;

    public Usuario() {}

    public Usuario(String nombre,  int run, LocalDate fechaNacimiento, String email) {
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.run = run;
        this.email = email;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if (nombre.length() >= 10 && nombre.length() <= 50) {
            this.nombre = nombre;
        } else {
            System.out.println("El nombre debe tener entre 10 y 50 caracteres.");
        }
    }
    

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public int getRun() {
        return run;
    }

    public void setRun(int run) {
        if (run >0 && run < 999999999) {
            this.run = run;
        } else {
            System.out.println("El RUN debe ser menor a 99.999.999.");
        }
    }
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String fechaNacimientoStr = "";
        if (fechaNacimiento != null) {
            fechaNacimientoStr = fechaNacimiento.format(formatter);
        }
        return "Nombre: " + nombre + ", Fecha de nacimiento: " + fechaNacimiento + "Run=" + run + "]";
    }

    
    public int getEdad() {
        LocalDate fechaActual = LocalDate.now();
        Period periodo = Period.between(fechaNacimiento, fechaActual);
        return periodo.getYears();
    }

    public String mostrarEdad() {
        return "El usuario tiene " + getEdad() + " anios";
    }

    @Override
    public void analizarUsuario() {
        System.out.println("Nombre: " + getNombreCompleto());
        System.out.println("RUN: " + getRun());
    }
    
   
}
