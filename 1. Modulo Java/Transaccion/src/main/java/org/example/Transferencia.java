package org.example;

public class Transferencia implements ITransaccion {

    public Transferencia() {
    }

    @Override
    public String transaccionOk() {
        return "Realizándose transferencia";
    }

    @Override
    public String transaccionNoOk() {
        return "La acción transferencia no es permitida";
    }
}
