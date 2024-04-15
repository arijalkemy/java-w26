package org.example.ejercicio1;

public class RetiroEfectivo implements ITransaccion{
    @Override
    public void transaccionOk() {
        System.out.println("El retiro de efectivo Ok");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("El retiro de efectivo NO se pudo realizar");
    }
}
