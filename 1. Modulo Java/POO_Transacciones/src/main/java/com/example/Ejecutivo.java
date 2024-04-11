package com.example;

public class Ejecutivo {

    Transaccion transaccion;

    public void depositar(){
        this.transaccion = new Deposito();
        this.transaccion.transaccionOk();
    }
}
