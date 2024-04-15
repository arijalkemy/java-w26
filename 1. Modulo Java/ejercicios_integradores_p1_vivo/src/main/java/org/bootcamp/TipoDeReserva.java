package org.bootcamp;

public enum TipoDeReserva {
    HOTEL("Hotel"),
    COMIDA("Comida"),
    VIAJE("Viaje"),
    TRANSPORTE("Transporte");

    private final String valor;

    TipoDeReserva(String value) {
        this.valor = value;
    }

    public final String getValue() {
        return this.valor;
    }
}
