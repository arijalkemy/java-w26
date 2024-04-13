package org.example.agenciaDeTurismo.reservas;

public abstract class Reserva {
    private int cantidad;
    private double costoBase;

    public Reserva(int cantidad, double costoBase) {
        this.cantidad = cantidad;
        this.costoBase = cantidad * costoBase;
    }

    public int getCantidad() {
        return cantidad;
    }

    public double getCostoBase() {
        return costoBase;
    }

    public abstract double getCosto();
}
