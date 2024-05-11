package com.w26.romanos.entity;

public class NumericComposition {
    private int numero;
    private int potencia;

    public NumericComposition(int numero, int potencia) {
        this.numero = numero;
        this.potencia = potencia;
    }

    public static NumericComposition of(int numero, int potencia) {
        return new NumericComposition(numero, potencia);
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getPotencia() {
        return potencia;
    }

    public void setPotencia(int potencia) {
        this.potencia = potencia;
    }

    @Override
    public String toString() {
        return "[" + numero + ", " + potencia + "]";
    }
}

