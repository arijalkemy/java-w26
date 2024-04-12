package com.example;

import java.util.List;

public class Localizador {

    private Cliente cliente;
    private List<Reserva> reservas;

    public Localizador(Cliente cliente, List<Reserva> reservas) {
        this.cliente = cliente;
        this.reservas = reservas;
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

    public double getTotal(){
        return reservas
            .stream()
            .mapToDouble(Reserva::calcularTotal)
            .sum();
    }
}