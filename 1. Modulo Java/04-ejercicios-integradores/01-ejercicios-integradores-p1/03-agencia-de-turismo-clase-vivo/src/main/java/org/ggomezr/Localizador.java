package org.ggomezr;

import java.util.ArrayList;
import java.util.List;

public class Localizador {
    private String cliente;
    private List<Reserva> reservas;

    public Localizador(String cliente) {
        this.cliente = cliente;
        this.reservas = new ArrayList<>();
    }

    public void agregarReserva(Reserva reserva) {
        reservas.add(reserva);
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
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
        return "Localizador{" +
                "cliente='" + cliente + '\'' +
                ", reservas=" + reservas +
                '}';
    }
}
