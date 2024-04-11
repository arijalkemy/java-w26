package org.example;

public class Deposito implements Transaccion{
    public void TransaccionOk() {
        System.out.println("Deposito exitoso");
    }

    public void TransaccionNoOk() {
        System.out.println("Deposito no exitoso");
    }
}
