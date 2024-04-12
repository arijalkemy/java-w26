package ej1.modelo.transacciones;

import ej1.interfaces.ITransaccion;

public class RetiroDeEfectivo implements ITransaccion {
    @Override
    public void transaccionOk() {
        System.out.println("Retiro de efectivo realizado con exito");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Retiro de efectivo no realizado con exito");
    }
}
