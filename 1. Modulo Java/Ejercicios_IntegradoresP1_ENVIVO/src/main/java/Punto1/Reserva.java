package Punto1;

public class Reserva {
    private String descripcion;
    private double costo;

    public Reserva(String descripcion, double costo) {
        this.descripcion = descripcion;
        this.costo = costo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public double getCosto() {
        return costo;
    }
}
