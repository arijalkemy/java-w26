package org.example;

public class RetiroEfectivo implements Transaccion{
    @Override
    public void TransaccionOk() {
        System.out.println("Retiro exitoso");
    }

    @Override
    public void TransaccionNoOk() {
        System.out.println("Retiro no exitoso");
    }
}
