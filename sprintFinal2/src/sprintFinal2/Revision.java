package sprintFinal2;

public class Revision {
    private int identificador;
    private int identificadorVisita;
    private String nombre;
    private String detalle;
    private int estado;

    public Revision() {}

    public Revision(int identificador, int identificadorVisita, String nombre, String detalle, int estado) {
        this.identificador = identificador;
        this.identificadorVisita = identificadorVisita;
        this.nombre = nombre;
        this.detalle = detalle;
        this.estado = estado;
    }

    public int getIdentificador() {
        return identificador;
    }

    public void setIdentificador(int identificador) {
        this.identificador = identificador;
    }

    public int getIdentificadorVisita() {
        return identificadorVisita;
    }

    public void setIdentificadorVisita(int identificadorVisita) {
        this.identificadorVisita = identificadorVisita;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        if (estado < 1 || estado > 3) {
            throw new IllegalArgumentException("El estado debe ser 1 (sin problemas), 2 (con observaciones) o 3 (no aprueba)");
        }
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Revision [identificador=" + identificador + ", identificadorVisita=" + identificadorVisita + ", nombre=" + nombre + ", detalle=" + detalle + ", estado=" + estado + "]";
    }
}

