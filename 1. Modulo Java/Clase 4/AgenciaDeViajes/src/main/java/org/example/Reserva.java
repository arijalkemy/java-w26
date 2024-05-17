package org.example;

public class Reserva {
    /*
    * 1. Reserva Hotel
    * 2. Comida
    * 3. Viaje
    * 4. Trasnporte
    * */

    private String descripcion;
    private tipoReserva tipoReserva;
    private double costoReserva;
    private double descuento;

    public Reserva(String descripcion, org.example.tipoReserva tipoReserva, double costoReserva) {
        this.descripcion = descripcion;
        this.tipoReserva = tipoReserva;
        this.costoReserva = costoReserva;
    }

    public double getCostoReserva() {
        return costoReserva;
    }

    public org.example.tipoReserva getTipoReserva() {
        return tipoReserva;
    }

    public void aplicarDescuentoReserva(double descuento){
        double restado = this.costoReserva * descuento;
        this.costoReserva = this.costoReserva - restado;

    }
}
