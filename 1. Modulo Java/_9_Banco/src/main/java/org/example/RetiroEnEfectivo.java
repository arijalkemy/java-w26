package org.example;

public class RetiroEnEfectivo implements ITransaccion{
    @Override
    public void transaccionOk() {
        System.out.println("Se realizo el retiro en efectivo");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("No se realizo el retiro en efectivo");
    }
}
