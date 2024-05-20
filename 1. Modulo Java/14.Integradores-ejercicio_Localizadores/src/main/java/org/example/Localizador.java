package org.example;

import java.util.List;

public class Localizador {
    private Cliente cliente;
    private List<Reserva> reservas;
    private double total;
    private double descuento;


    public Localizador(Cliente cliente, List<Reserva> reservas) {
        this.cliente = cliente;
        this.reservas = reservas;
        this.total = reservas.stream().mapToDouble(Reserva::getValor).sum();
        this.descuento = 0;
    }

    public boolean tieneTodasLasreservas() {
        List<String> todosLosTipos = List.of("hotel", "comida", "boleto");
        List<String> tipos = this.reservas.stream().map(Reserva::getTipo).toList();
        return tipos.containsAll(todosLosTipos);
    }

    public boolean tieneDosReservasHoTelOviaje() {
        List<String> tipos = this.reservas.stream().map(Reserva::getTipo).toList();
        return tipos.stream().filter(t -> t.equals("hotel")).count() >= 2 || tipos.stream().filter(t -> t.equals("boleto de viaje")).count() >= 2;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(List<Reserva> reservas) {
        this.reservas = reservas;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public double getDescuento() {
        return descuento;

    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    @Override
    public String toString() {
        return "Localizador{" +
                "cliente=" + cliente.toString() +
                ", reservas=" + reservas.toString() +
                ", total=" + total +
                ", totalConDescuento=" + descuento +
                '}';
    }

}
