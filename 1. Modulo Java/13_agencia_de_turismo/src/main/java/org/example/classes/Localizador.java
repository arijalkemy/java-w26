package org.example.classes;

import java.util.ArrayList;
import java.util.List;

public class Localizador {

    private Cliente cliente;
    private List<Reserva> reservas;
    private double costoTotal;

    public Localizador(Cliente cliente) {
        this.cliente = cliente;
        this.reservas = new ArrayList<>();
        this.costoTotal = 0;
    }

    public void agregarReserva(Reserva reserva) {
        this.reservas.add(reserva);
        this.setCostoTotal(this.getCostoTotal() + reserva.getCosto());
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

    public double getCostoTotal() {
        return costoTotal;
    }

    public void setCostoTotal(double costoTotal) {
        this.costoTotal = costoTotal;
    }

    @Override
    public String toString() {
        return "Localizador{" +
                "cliente=" + cliente +
                ", costoTotal=" + costoTotal +
                '}';
    }
}
