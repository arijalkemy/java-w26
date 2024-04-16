package Clases;

public class Reserva {

    private String tipoReserva;

    private double precio;

    public Reserva(String tipoReserva, double precio) {
        this.tipoReserva = tipoReserva;
        this.precio = precio;
    }

    public double getPrecio() {
        return precio;
    }

    public String getTipoReserva() {
        return tipoReserva;
    }
}
