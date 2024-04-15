package org.example;

import java.util.UUID;

public class Localizador {
    private UUID id;
    private Cliente client;
    private double total;
    private Reserva reserva;

    public Localizador(Cliente client, double total, Reserva reserva) {
        this.id = UUID.randomUUID();
        this.client = client;
        this.total = total;
        this.reserva = reserva;
    }

    public UUID getId() {
        return id;
    }

    public Cliente getClient() {
        return client;
    }

    public void setClient(Cliente client) {
        this.client = client;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Reserva getReserva() {
        return reserva;
    }

    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
    }
}
