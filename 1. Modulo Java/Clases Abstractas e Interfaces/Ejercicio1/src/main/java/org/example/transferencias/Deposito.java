package org.example;

public class Deposito implements ITransaccion{

    @Override
    public void transaccionOk() {
        System.out.println("Realizando deposito...");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Deposito rechazado.");
    }
}
