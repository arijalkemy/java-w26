package com.meli;

public class Basic implements Transaccion{
    @Override
    public void transaccionOk() {
        System.out.println("transaccion realizada con éxito basic");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("transaccion no realizada basic");
    }

    public void consultarSaldo() {
        System.out.println("Su saldo es: 10000");
    }

    public void pagarServicio() {
        System.out.println("Su pago de servicio se esta realizando...");
    }

    public void retirarEfectivo() {
        System.out.println("Su efectivo se esta procesando...");
    }
}
