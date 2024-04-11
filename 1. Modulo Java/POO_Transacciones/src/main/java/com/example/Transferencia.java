package com.example;

public class Transferencia implements Transaccion{

    @Override
    public void transaccionOk() {
        System.out.println("Se ha realizado la transaccion con exito.");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Ha ocurrido un error al realizar la transferencia.");
    }
    
}
