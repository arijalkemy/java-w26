package org.example.viajes;

public class Reserva {
    private String tipo; // hotel, comida, boletos, transporte
    private double precio;

    public Reserva(String tipo, double precio) {
        this.tipo = tipo;
        this.precio = precio;
    }

    public String getTipo() {
        return tipo;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
}
