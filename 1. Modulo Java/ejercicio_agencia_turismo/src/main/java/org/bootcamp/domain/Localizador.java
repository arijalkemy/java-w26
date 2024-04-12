package org.bootcamp.domain;

import java.util.List;

public class Localizador {

    private static int contadorId = 0;
    private int id;
    private Cliente cliente;
    private List<Reserva> reservas;
    private double subtotal;
    private double descuento;
    private double total;


    public Localizador() {
        this.id = ++contadorId;
    }

    public Localizador(Cliente cliente, List<Reserva> reservas, double subtotal) {
        this.cliente = cliente;
        this.reservas = reservas;
        this.subtotal = subtotal;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(List<Reserva> reservas) {
        this.reservas = reservas;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("---- Localizador ----");
        sb.append("\nid: ").append(id);
        sb.append("\ncliente: ").append(cliente);
        sb.append("\nreservas: ").append(reservas);
        return sb.toString();
    }
}
