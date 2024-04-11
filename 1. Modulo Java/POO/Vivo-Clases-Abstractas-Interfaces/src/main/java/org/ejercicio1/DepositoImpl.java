package org.ejercicio1;

public class DepositoImpl implements ITransaccion {
    @Override
    public void transaccionOk() {
        System.out.println("Depósito realizado con éxito");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("No se pudo realizar el depósito");
    }
}
