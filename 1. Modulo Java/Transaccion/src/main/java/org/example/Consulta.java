package org.example;

public class Consulta implements ITransaccion {

    public Consulta() {
    }

    @Override
    public String transaccionOk() {
        return "Realizándose consulta";
    }

    @Override
    public String transaccionNoOk() {
        return "La acción consulta no es permitida";
    }
}
