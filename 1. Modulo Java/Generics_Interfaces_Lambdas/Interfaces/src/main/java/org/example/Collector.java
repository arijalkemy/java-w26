package org.example;

public class Collector implements ITransaction {

    public Collector() {
    }

    public void showBalance() {
        transactionCompleted();
        System.out.println("Show Balance");
    }

    public void withdrawal() {
        transactionCompleted();
        System.out.println("Money Withdrawal");
    }

    public void servicePayment() {
        transactionFailed();
    }

    public void transferMoney() {
        transactionFailed();
    }

    @Override
    public void transactionCompleted() {
        System.out.println("Transaction Completed");
    }

    @Override
    public void transactionFailed() {
        System.out.println("Transaction Failed");
    }
}
