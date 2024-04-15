package org.bootcamp;

public class Reserva {
   private String descripción;
   private TipoDeReserva tipoReserva;
   private double precio;

    public Reserva(String descripción, TipoDeReserva tipoReserva, double precio) {
        this.descripción = descripción;
        this.tipoReserva = tipoReserva;
        this.precio = precio;
    }

    public String getDescripción() {
        return descripción;
    }

    public void setDescripción(String descripción) {
        this.descripción = descripción;
    }

    public TipoDeReserva getTipoReserva() {
        return tipoReserva;
    }

    public void setTipoReserva(TipoDeReserva tipoReserva) {
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
        return "Reserva de " + tipoReserva.getValue() + ": " + descripción + " $" + precio;
    }
}
