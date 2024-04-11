package org.example;

public class ServicePayment implements Transaction {
    public ServicePayment() {
    }
    @Override
    public void transactionOk() {
        System.out.println("Payment of services was ok");
    }

    @Override
    public void transactionNoOk() {
        System.out.println("Payment of services has an error");
    }
}
