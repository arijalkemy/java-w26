package org.example;

import org.example.enums.Tipo_Reserva;

public class Reserva {
    private Tipo_Reserva tipoReserva;
    private double costoReserva;

    public double getCostoReserva() {
        return costoReserva;
    }

    @Override
    public String toString() {
        return "Reserva{" +
                "tipoReserva=" + tipoReserva +
                ", costoReserva=" + costoReserva +
                '}';
    }

    public Tipo_Reserva getTipoReserva() {
        return tipoReserva;
    }

    public Reserva(Tipo_Reserva tipoReserva, double costoReserva) {
        this.tipoReserva = tipoReserva;
        this.costoReserva = costoReserva;
    }
}


