package org.example;

public class Balance implements Transaction {
    public Balance() {
    }
    @Override
    public void transactionOk() {
        System.out.println("Balance was ok");
    }

    @Override
    public void transactionNoOk() {
        System.out.println("Balance has an error");
    }
}
