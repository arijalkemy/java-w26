package org.example;

public class Reserva {
    private int descuento;
    private Cliente cliente;
    private Paquete paquete;

    public Reserva() {
    }

    public Reserva(int descuento, Cliente cliente, Paquete paquete) {
        this.descuento = descuento;
        this.cliente = cliente;
        this.paquete = paquete;
    }

    public int getDescuento() {
        return descuento;
    }

    public void setDescuento(int descuento) {
        this.descuento = descuento;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Paquete getPaquete() {
        return paquete;
    }

    public void setPaquete(Paquete paquete) {
        this.paquete = paquete;
    }
}
