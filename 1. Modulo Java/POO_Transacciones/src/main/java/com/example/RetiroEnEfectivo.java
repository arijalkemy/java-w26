package com.example;

public class RetiroEnEfectivo implements Transaccion{

    @Override
    public void transaccionOk() {
        System.out.println("Se ha realizado el retiro en efectivo con exito.");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Ha ocurrido un problema al realizar el retiro en efectivo.");
    }
    
}
