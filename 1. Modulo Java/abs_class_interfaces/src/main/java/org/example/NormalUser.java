package org.example;

public abstract class NormalUser {
    public NormalUser() {
    }
    public void cashWithdraw() {
        Cash cash = new Cash();
        cash.transactionOk();
    }

    public void viewBalance() {
        Balance balance = new Balance();
        balance.transactionNoOk();
    }
}
