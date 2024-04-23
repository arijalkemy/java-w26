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

    public Localizador(Cliente cliente, List<Reserva> reservas) {
        this.id = ++contadorId;
        this.cliente = cliente;
        this.reservas = reservas;
        this.subtotal = subtotal;
        calcularSubtotal();
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
        final StringBuffer sb = new StringBuffer("\n\n---- Localizador ----");
        sb.append("\nid: ").append(id);
        sb.append("\nInformación cliente: ").append(cliente);
        sb.append("\nreservas: ").append(reservas);
        sb.append("\n\nsubtotal: ").append(subtotal);
        sb.append("\ndescuento: ").append(descuento);
        sb.append("\ntotal: ").append(total);
        return sb.toString();
    }

    private void calcularSubtotal (){
        if(!reservas.isEmpty()){
            reservas.forEach(reserva -> this.subtotal += reserva.getValor());
        }
        this.total = subtotal;
    }


    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
