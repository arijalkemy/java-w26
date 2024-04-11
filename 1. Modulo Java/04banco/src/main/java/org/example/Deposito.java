package org.example;

public class Deposito implements ITransaccion {
    @Override
    public void transaccionOk() {
        System.out.println("Depósito OK");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Depósito No Ok");
    }
}

