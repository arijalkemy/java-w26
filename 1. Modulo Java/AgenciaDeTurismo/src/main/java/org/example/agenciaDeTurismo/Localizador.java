package org.example.agenciaDeTurismo;

import org.example.agenciaDeTurismo.reservas.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Localizador {
    private Cliente cliente;
    private List<Reserva> reservas = new ArrayList<>();
    private double total;

    public Localizador(Cliente cliente, ReservaHotel reservaHotel, ReservaViaje reservaViaje, ReservaComida reservaComida, ReservaTransporte reservaTransporte) {
        this.cliente = cliente;
        if(reservaHotel != null) {
            reservas.add(reservaHotel);
        }
        if(reservaViaje != null) {
            reservas.add(reservaViaje);
        }
        if(reservaComida != null) {
            reservas.add(reservaComida);
        }
        if(reservaTransporte != null) {
            reservas.add(reservaTransporte);
        }
        this.total = calcularTotal();
    }

    private double calcularTotal() {
        double descuento = (reservas.size() == 4 ? 0.1: 0);
        descuento += (cliente.getLocalizadores().size() >= 2 ? 0.05 : 0);
        //Sumamos valor de reservas
        double total = this.reservas.stream().mapToDouble(Reserva::getCosto).sum();
        //Le restamos descuentos
        total -= total * (descuento);
        return total;
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

    @Override
    public String toString() {
        return "Localizador{" +
                "cliente=" + cliente +
                ",\n reservas=" + reservas +
                ",\n total=" + total +
                '}';
    }
}
