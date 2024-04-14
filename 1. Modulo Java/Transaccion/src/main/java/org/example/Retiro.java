package org.example;

public class Retiro implements ITransaccion {

    public Retiro() {
    }

    @Override
    public String transaccionOk() {
        return "Realizándose retiro";
    }

    @Override
    public String transaccionNoOk() {
        return "La acción retiro no es permitida";
    }
}
