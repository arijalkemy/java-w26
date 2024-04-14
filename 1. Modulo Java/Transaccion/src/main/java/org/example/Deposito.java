package org.example;

public class Deposito implements ITransaccion {

    public Deposito() {
    }

    @Override
    public String transaccionOk() {
        return "Realizándose depósito";
    }

    @Override
    public String transaccionNoOk() {
        return "La acción depósito no es permitida";
    }
}
