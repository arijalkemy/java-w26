package org.example;

public class Transferencia implements ITransaccion {

    @Override
    public void transaccionOk() {
        System.out.println("Se realizo la transferencia");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("No se realizo la transferencia");
    }
}
