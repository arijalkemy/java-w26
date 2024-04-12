package org.bootcamp.transaccional.impl;

import org.bootcamp.transaccional.ITransaccion;

public class ConsultaSaldo implements ITransaccion {

    @Override
    public void transaccionOK() {
        System.out.println("¡Consulta de saldo exitosa!");
    }

    @Override
    public void transaccionNoOK() {
        System.out.println("¡No se pudo realizar la consulta del saldo!");
    }
}
