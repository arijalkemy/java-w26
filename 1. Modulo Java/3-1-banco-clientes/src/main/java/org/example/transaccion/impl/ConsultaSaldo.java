package org.example.transaccion.impl;


import org.example.transaccion.ITransaccion;

public class ConsultaSaldo implements ITransaccion {


    @Override
    public void transaccionOK() {
        System.out.println("Consulta Saldo OK");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Consulta Saldo no ok");
    }
}