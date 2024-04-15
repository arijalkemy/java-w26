package org.example;

import java.util.List;

public class Localizador {

    private Cliente cliente;
    private int total;
    List<Reserva> reservas;


    public List<Reserva> getReservas() {
        return reservas;
    }

    public Localizador setReservas(List<Reserva> reservas) {
        this.reservas = reservas;
        return this;
    }

    public boolean localizadorTieneCliente(Cliente cliente) {
        for (Reserva r : reservas) {
            if (r.getCliente().equals(cliente)) {
                return true;
            }
        }
        return false;
    }
}
