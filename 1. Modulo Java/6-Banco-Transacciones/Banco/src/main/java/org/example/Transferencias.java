package org.example;

public class Transferencias implements Transaccion{
    @Override
    public void TransaccionOk() {
        System.out.println("Transferencia exitoso");
    }

    @Override
    public void TransaccionNoOk() {
        System.out.println("Transferencia no exitoso");
    }
}
