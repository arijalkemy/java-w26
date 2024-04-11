package org.example;

public class Executive implements ITransaction {

    public Executive() {
    }

    public void transferMoney() {
        transactionCompleted();
        System.out.println("Money Transferred");
    }

    public void withdrawal() {
        transactionCompleted();
        System.out.println("Money Withdrawal");
    }

    public void showBalance() {
        transactionFailed();
    }

    public void servicePayment() {
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
