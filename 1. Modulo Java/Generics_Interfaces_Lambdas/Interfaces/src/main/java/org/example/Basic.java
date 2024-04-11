package org.example;

public class Basic implements ITransaction {

    public Basic() {
    }

    public void showBalance() {
        transactionCompleted();
        System.out.println("Show Balance");
    }

    public void servicePayment() {
        transactionCompleted();
        System.out.println("Payment Successful");
    }

    public void withdrawal() {
        transactionCompleted();
        System.out.println("Money Withdrawal");
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
