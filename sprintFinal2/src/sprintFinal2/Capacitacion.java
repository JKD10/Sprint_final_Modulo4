package sprintFinal2;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Capacitacion {
    private int identificador;
    private String rutCliente;
    private String dia;
    private String hora;
    private String lugar;
    private int duracion;
    private int cantidadAsistentes;

    

    public Capacitacion() {
        
    }

	public int getIdentificador() {
        return identificador;
    }

    public void setIdentificador(int identificador) {
        this.identificador = identificador;
    }

    public String getRutCliente() {
        return rutCliente;
    }

    public void setRutCliente(String rutCliente) {
        this.rutCliente = rutCliente;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        if (dia.equalsIgnoreCase("lunes") || dia.equalsIgnoreCase("martes") || dia.equalsIgnoreCase("miercoles") || dia.equalsIgnoreCase("jueves") || dia.equalsIgnoreCase("viernes") || dia.equalsIgnoreCase("sábado") || dia.equalsIgnoreCase("domingo")) {
            this.dia = dia;
        } else {
            System.out.println("El día debe ser un valor permitido entre \"lunes\" y \"domingo\" (en ese formato).");
        }
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        sdf.setLenient(false);
        try {
            Date d = sdf.parse(hora);
            this.hora = hora;
        } catch (Exception e) {
            System.out.println("La hora debe ser una hora valida del dia, en formato HH:MM (hora desde 0 a 23, minutos entre 0 y 59).");
        }
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        if (lugar.length() >= 10 && lugar.length() <= 50) {
            this.lugar = lugar;
        } else {
            System.out.println("El lugar debe tener entre 10 y 50 caracteres.");
        }
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        if (duracion <= 70) {
            this.duracion = duracion;
        } else {
            System.out.println("La duración no debe superar los 70 caracteres.");
        }
    }

    public int getCantidadAsistentes() {
        return cantidadAsistentes;
    }

    public void setCantidadAsistentes(int cantidadAsistentes) {
        if (cantidadAsistentes < 1000) {
            this.cantidadAsistentes = cantidadAsistentes;
        } else {
            System.out.println("La cantidad de asistentes debe ser un numero entero menor que 1000.");
        }
    }

    @Override
    public String toString() {
        return "Capacitacion [identificador=" + identificador + ", rutCliente=" + rutCliente + ", dia=" + dia + ", hora=" + hora + ", lugar=" + lugar + ", duracion=" + duracion + ", cantidadAsistentes=" + cantidadAsistentes + "]";
    }
    
    public String mostrarDetalle() {
        return "La capacitacion sera en " + lugar + " a las " + hora + " del dia " + dia + ", y durara " + duracion + " minutos.";
    }

   
}

