package org.example;

import java.util.Date;
import java.util.UUID;

public class Reserva {
    public UUID id;
    public int hotel;
    public int comida;
    public int boletos;
    public int transporte;
    public Date fechaConfirmacion;

    public Reserva(int hotel, int comida, int boletos, int transporte) {
        this.id = UUID.randomUUID();
        this.hotel = hotel;
        this.comida = comida;
        this.boletos = boletos;
        this.transporte = transporte;
        this.fechaConfirmacion = null;
    }
}
