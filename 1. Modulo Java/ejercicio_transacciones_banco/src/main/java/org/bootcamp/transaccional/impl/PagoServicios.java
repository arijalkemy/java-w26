package org.bootcamp.transaccional.impl;

import org.bootcamp.transaccional.ITransaccion;

public class PagoServicios implements ITransaccion {
    @Override
    public void transaccionOK() {
        System.out.println("¡Pago de servicios realizado con exito!");
    }

    @Override
    public void transaccionNoOK() {
        System.out.println("¡No se pudo realizar el pago del servicio con exito!");
    }
}
