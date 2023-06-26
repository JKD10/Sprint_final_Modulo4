package sprintFinal2;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class VisitaEnTerreno {
    private int identificador;
    private String rutCliente;
    private Date dia;
    private String hora;
    private String lugar;
    private String comentarios;
    //private List<Revision> revisiones;

    public VisitaEnTerreno() {}

    public VisitaEnTerreno(int identificador, String rutCliente, Date dia, String hora, String lugar, String comentarios) {
        this.identificador = identificador;
        this.rutCliente = rutCliente;
        this.dia = dia;
        this.hora = hora;
        this.lugar = lugar;
        this.comentarios = comentarios;
        //this.revisiones = new ArrayList<>();
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

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return "Visita en Terreno [Identificador: " + identificador + ", RUT Cliente: " + rutCliente + ", Dia: " + sdf.format(dia) + ", Hora: " + hora + ", Lugar: " + lugar + ", Comentarios: " + comentarios + "]";
    }
    
    /*public void agregarRevision(Revision revision) {
        revisiones.add(revision);
    }*/
}
