package com.example;

public class Deposito implements Transaccion{

    @Override
    public void transaccionOk() {
        System.out.println("Se ha realizado el deposito con exito.");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Hubo un problema al realizar el deposito.");
    }

}
