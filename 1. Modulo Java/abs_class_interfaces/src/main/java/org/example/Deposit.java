package org.example;

public class Deposit implements Transaction{
    public Deposit() {
    }

    @Override
    public void transactionOk() {
        System.out.println("Deposit was ok");
    }

    @Override
    public void transactionNoOk() {
        System.out.println("Deposit has an error");
    }
}
