package org.example;

public class Executive {
    public void makeDeposit() {
        Deposit deposit = new Deposit();
        deposit.transactionOk();
    }

    public void makeTransfer() {
        Transfer transfer = new Transfer();
        transfer.transactionNoOk();
    }
}
