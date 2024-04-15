package org.example.boleto;

import org.example.pasajero.Pasajero;
import org.example.vuelo.Escala;

import java.util.UUID;

public class Boleto {
    private UUID id;
    private Pasajero pasajero;
    private Escala inicioRuta;
    private Escala finalRuta;

    public Boleto(Pasajero pasajero, Escala inicioRuta, Escala finalRuta) {
        this.id = UUID.randomUUID();
        this.pasajero = pasajero;
        this.inicioRuta = inicioRuta;
        this.finalRuta = finalRuta;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Pasajero getPasajero() {
        return pasajero;
    }

    public void setPasajero(Pasajero pasajero) {
        this.pasajero = pasajero;
    }

    public Escala getInicioRuta() {
        return inicioRuta;
    }

    public void setInicioRuta(Escala inicioRuta) {
        this.inicioRuta = inicioRuta;
    }

    public Escala getFinalRuta() {
        return finalRuta;
    }

    public void setFinalRuta(Escala finalRuta) {
        this.finalRuta = finalRuta;
    }
}
