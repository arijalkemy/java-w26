package org.example;

public enum TipoReserva {
    HOT("Hotel"),
    COM("Comida"),
    BOL("Boleto"),
    TRANS("Transporte")
    ;

    private final String tipo;

    TipoReserva(final String tipo){
        this.tipo = tipo;
    }

    @Override
    public String toString(){
        return this.tipo;
    }
}
