package org.example.model;

public class PagoDeServicio implements Transaccion{
    @Override
    public void transaccionOk() {
        System.out.println("Pago de servicios realizado");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Pago de servicios no realizado");
    }

}
