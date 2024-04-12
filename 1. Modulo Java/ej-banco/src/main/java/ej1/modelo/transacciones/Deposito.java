package ej1.modelo.transacciones;

import ej1.interfaces.ITransaccion;

public class Deposito implements ITransaccion {
    @Override
    public void transaccionOk() {
        System.out.println("Deposito realizado con exito");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Deposito realizado sin exito");
    }
}
