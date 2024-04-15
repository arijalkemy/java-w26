package org.example;

public class Reserva {
    /*
    * 1. Reserva Hotel
    * 2. Comida
    * 3. Viaje
    * 4. Transporte
    * */

    private String descripcion;
    private TipoReserva tipoReserva;
    private double costoReserva;

    public Reserva(String descripcion, TipoReserva tipoReserva, double costoReserva) {
        this.descripcion = descripcion;
        this.tipoReserva = tipoReserva;
        this.costoReserva = costoReserva;
    }

    public double getCostoReserva() {
        return costoReserva;
    }

    public TipoReserva getTipoReserva() {
        return tipoReserva;
    }

    public double getCostoConDescuentoReserva(double descuento){
       return (1-descuento)*this.costoReserva;
    }

    @Override
    public String toString() {
        return "Descripcion= " + descripcion +" TipoReserva= " + tipoReserva + " CostoReserva= " + costoReserva;
    }
}
