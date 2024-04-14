package org.example;

public class Pago implements ITransaccion{

    public Pago() {
    }

    @Override
    public String transaccionOk() {
        return "Realizándose pago";
    }

    @Override
    public String transaccionNoOk() {
        return "La acción pago no es permitida";
    }
}
