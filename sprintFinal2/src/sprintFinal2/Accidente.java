package sprintFinal2;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Clase que representa un Accidente.
 */

public class Accidente {
    private int identificador;
    private String rutCliente;
    private Date dia;
    private String hora;
    private String lugar;
    private String origen;
    private String consecuencias;

    /**
     * Constructor por defecto de la clase Accidente.
     */
    public Accidente() {}
    
    /**
     * Constructor de la clase Accidente.
     *
     * @param identificador     Identificador del accidente.
     * @param rutCliente        Rut del cliente asociado al accidente.
     * @param dia               Fecha del accidente.
     * @param hora              Hora del accidente.
     * @param lugar             Lugar del accidente.
     * @param origen            Origen del accidente.
     * @param consecuencias     Consecuencias del accidente.
     */

    public Accidente(int identificador, String rutCliente, Date dia, String hora, String lugar, String origen, String consecuencias) {
        this.identificador = identificador;
        this.rutCliente = rutCliente;
        this.dia = dia;
        this.hora = hora;
        this.lugar = lugar;
        this.origen = origen;
        this.consecuencias = consecuencias;
    }

    /**
     * Obtiene el identificador del accidente.
     *
     * @return El identificador del accidente.
     */
    
    public int getIdentificador() {
        return identificador;
    }
    
    /**
     * Establece el identificador del accidente.
     *
     * @param identificador El identificador del accidente.
     */

    public void setIdentificador(int identificador) {
        this.identificador = identificador;
    }

    /**
     * Obtiene el Rut del cliente asociado al accidente.
     *
     * @return El Rut del cliente asociado al accidente.
     */
    
    public String getRutCliente() {
        return rutCliente;
    }

    public void setRutCliente(String rutCliente) {
        this.rutCliente = rutCliente;
    }

    public Date getDia() {
        return dia;
    }

    public void setDia(Date dia) {
        this.dia = dia;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getConsecuencias() {
        return consecuencias;
    }

    public void setConsecuencias(String consecuencias) {
        this.consecuencias = consecuencias;
    }

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return "Accidente{" +
                "identificador=" + identificador +
                ", rutCliente='" + rutCliente + '\'' +
                ", dia=" + sdf.format(dia) +
                ", hora='" + hora + '\'' +
                ", lugar='" + lugar + '\'' +
                ", origen='" + origen + '\'' +
                ", consecuencias='" + consecuencias + '\'' +
                '}';
    }
}
