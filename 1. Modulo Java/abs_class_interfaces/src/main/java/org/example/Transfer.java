package org.example;

public class Transfer implements Transaction{
    public Transfer() {
    }
    @Override
    public void transactionOk() {
        System.out.println("Transfer was ok");
    }

    @Override
    public void transactionNoOk() {
        System.out.println("Transfer has an error");
    }
}
