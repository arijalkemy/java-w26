package org.example;

public class Reserva {
    private String tipoReserva;
    private double precio;

    public Reserva(String tipoReserva, double precio) {
        this.tipoReserva = tipoReserva;
        this.precio = precio;
    }

    public String getTipoReserva() {
        return tipoReserva;
    }

    public void setTipoReserva(String tipoReserva) {
        this.tipoReserva = tipoReserva;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Reserva: {\n" +
                "Tipo de Reserva =  " + tipoReserva + "\n"+
                "Precio = " + precio + "\n"+
                "}";
    }
}
