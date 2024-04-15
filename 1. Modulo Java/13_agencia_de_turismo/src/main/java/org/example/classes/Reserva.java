package org.example.classes;

public class Reserva {

    private String tipo;
    private double costo;

    public Reserva(String tipo, double costo) {
        this.tipo = tipo;
        this.costo = costo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }
}
