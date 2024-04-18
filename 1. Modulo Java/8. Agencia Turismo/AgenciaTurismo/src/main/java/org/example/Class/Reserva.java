package org.example.Class;

public class Reserva {

    private TipoReserva tipoReserva;
    private double precio;

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

    public void aplicarDescuento(int porcentaje){
        this.precio = precio - precio * porcentaje / 100;
    }


}
