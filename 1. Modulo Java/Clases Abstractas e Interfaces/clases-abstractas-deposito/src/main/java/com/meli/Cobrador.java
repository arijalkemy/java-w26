package com.meli;

public class Cobrador implements Transaccion{
    @Override
    public void transaccionOk() {
        System.out.println("transaccion realizada con éxito cobrador");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("transaccion no realizada cobrador");
    }

    public void retirarEfectivo() {
        System.out.println("Su efectivo se esta procesando...");
    }

    public void consultarSaldo() {
        System.out.println("Su saldo es: 10000");
    }
}
