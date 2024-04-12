package org.bootcamp.transaccional.impl;

import org.bootcamp.transaccional.ITransaccion;

public class Transferencia implements ITransaccion {
    @Override
    public void transaccionOK() {
        System.out.println("¡Transferencia realizada con exito!");
    }

    @Override
    public void transaccionNoOK() {
        System.out.println("¡No se pudo realizar la transferencia con exito!");
    }
}
