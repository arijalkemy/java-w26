package org.bootcamp.transaccional.impl;

import org.bootcamp.transaccional.ITransaccion;

public class RetiroEfectivo implements ITransaccion {
    @Override
    public void transaccionOK() {
        System.out.println("¡Retiro de efectivo realizado con exito!");
    }

    @Override
    public void transaccionNoOK() {
        System.out.println("¡No se pudo realizar el retiro de efectivo con exito!");
    }
}
