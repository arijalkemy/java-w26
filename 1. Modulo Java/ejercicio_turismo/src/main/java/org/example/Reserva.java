package org.example;

public class Reserva {
    private TipoReserva tipoReserva;
    private double precio;

    public Reserva(TipoReserva tipoReserva, double precio) {
        this.tipoReserva = tipoReserva;
        this.precio = precio;
    }

    public TipoReserva getTipoReserva() {
        return tipoReserva;
    }

    public void setTipoReserva(TipoReserva tipoReserva) {
        this.tipoReserva = tipoReserva;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString(){
        return "<" + this.tipoReserva + ">"+
                "Precio: " + this.precio + "\n";
    }
}
