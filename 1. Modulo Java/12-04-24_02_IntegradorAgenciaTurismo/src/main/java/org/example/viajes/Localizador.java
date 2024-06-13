package org.example.viajes;

import java.util.ArrayList;
import java.util.List;

public class Localizador {
    private Cliente cliente;
    private List<Reserva> reservas;
    private double total;

    public Localizador(Cliente cliente) {
        this.cliente = cliente;
        this.reservas = new ArrayList<>();
        this.total = 0.0;
    }

    public void agregarReserva(Reserva reserva) {
        this.reservas.add(reserva);
        this.total += reserva.getPrecio();
    }

    public Cliente getCliente() {
        return cliente;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    public double getTotal() {
        return total;
    }

    public void aplicarDescuento(double porcentaje) {
        this.total -= this.total * (porcentaje / 100);
    }

    public void imprimir() {
        System.out.println("Localizador para el cliente: " + cliente.getNombre());
        System.out.println("Reservas:");
        for (Reserva reserva : reservas) {
            System.out.println("- " + reserva.getTipo() + ": $" + reserva.getPrecio());
        }
        System.out.println("Total con descuento: $" + total);
    }
}
