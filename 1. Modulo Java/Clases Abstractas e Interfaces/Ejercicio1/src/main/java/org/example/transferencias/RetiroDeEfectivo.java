package org.example;

public class RetiroDeEfectivo implements ITransaccion{
    @Override
    public void transaccionOk() {
        System.out.println("Realizando retiro de efectivo...");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Retiro de efectivo rechazado.");
    }
}
