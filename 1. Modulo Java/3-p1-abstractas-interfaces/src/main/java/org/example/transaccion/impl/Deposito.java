package org.example.transaccion.impl;


import org.example.transaccion.ITransaccion;

public class Deposito implements ITransaccion {

    @Override
    public void transaccionOK() {
        System.out.println("Deposito OK");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Deposito no ok");
    }
}