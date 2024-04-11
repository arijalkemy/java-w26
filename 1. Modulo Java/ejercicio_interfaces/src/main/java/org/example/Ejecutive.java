package org.example;

public class Ejecutive implements Transaction{

    public Ejecutive () {

    }

    @Override
    public void transactionNoOk() {
        System.out.println("Transaction error");
    }

    @Override
    public void transactionOk() {
        System.out.println("Transaction ok");
    }

    public void deposito(double cantidad) {
        System.out.println("Deposito de " + cantidad);
    }

    public void transferencia (double cantidad, String destinatario) {
        System.out.println("Transferencia de " + cantidad + " a la cuenta " + destinatario);
    }

}
