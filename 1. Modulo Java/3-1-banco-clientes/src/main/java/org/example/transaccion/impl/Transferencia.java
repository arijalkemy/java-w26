package org.example.transaccion.impl;


import org.example.transaccion.ITransaccion;

public class Transferencia implements ITransaccion {

    @Override
    public void transaccionOK() {
        System.out.println("Transferencia OK");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Transferencia no ok");
    }
}