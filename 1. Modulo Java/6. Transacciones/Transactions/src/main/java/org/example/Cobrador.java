package org.example;

public class Cobrador extends OperacionesBasicas implements Transaction {

    public Cobrador(double saldo) {
        super(saldo);
    }

    @Override
    public void transactionNoOk() {
        System.out.println("Transaction error");
    }

    @Override
    public void transactionOk() {
        System.out.println("Transaction ok");
    }



}
