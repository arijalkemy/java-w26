package org.example;

import java.util.ArrayList;
import java.util.List;

public class Repositorio {
    public List<Reserva> listaReserva = new ArrayList<>();

    public Repositorio(List<Reserva> listaReserva) {
        this.listaReserva = listaReserva;
    }

    public List<Reserva> getListaReserva() {
        return listaReserva;
    }

    public void setListaReserva(List<Reserva> listaReserva) {
        this.listaReserva = listaReserva;
    }

    public Repositorio() {
    }

    public void addReserva(Reserva reserva) {
        this.listaReserva.add(reserva);
    }
}
