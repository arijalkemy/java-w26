package org.meli.clases;

public class Reserva {
    public String tipo;
    public Double valor;

    public Reserva(String tipo, Double valor) {
        this.tipo = tipo;
        this.valor = valor;
    }

    @Override

    public String toString() {
        return "  Reserva de "+tipo+" por $"+valor;
    }
}
