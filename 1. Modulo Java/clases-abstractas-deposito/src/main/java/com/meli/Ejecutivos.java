package com.meli;

public class Ejecutivos implements Transaccion {
    @Override
    public void transaccionOk() {
        System.out.println("transaccion realizada con éxito ejecutivos");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("transaccion no realizada ejecutivos");
    }

    public String deposito() {
        return "deposito realizado";
    }

    public void transferencia() {
        System.out.println("transferencia realizada");
    }
}
