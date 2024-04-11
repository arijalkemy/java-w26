package org.example;

public class Cash implements Transaction{
    public Cash() {
    }
    @Override
    public void transactionOk() {
        System.out.println("Cash withdrawal was ok");
    }

    @Override
    public void transactionNoOk() {
        System.out.println("Cash withdrawal has an error");
    }
}
