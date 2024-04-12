package org.bootcamp.transaccional.impl;

import org.bootcamp.transaccional.ITransaccion;

public class Deposito implements ITransaccion {
    @Override
    public void transaccionOK() {
        System.out.println("¡Depósito realizado con exito!");
    }

    @Override
    public void transaccionNoOK() {
        System.out.println("¡No se pudo realizar el depósito con éxito!");
    }
}
