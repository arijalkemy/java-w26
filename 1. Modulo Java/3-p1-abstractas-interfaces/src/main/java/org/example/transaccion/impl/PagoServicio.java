package org.example.transaccion.impl;


import org.example.transaccion.ITransaccion;

public class PagoServicio implements ITransaccion {
    @Override
    public void transaccionOK() {
        System.out.println("Pago Servicio OK");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Pago Servicio no ok");
    }
}