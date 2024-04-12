package com.example.ejercicioUno.Transactions;

public abstract class ClientTransaction {

    public static Deposit deposit = new Deposit();
    public static CheckBalance checkBalance = new CheckBalance();
    public static Transfer transfer = new Transfer();
    public static Withdraw withdraw = new Withdraw();
    public static ServicePayment servicePayment = new ServicePayment();

}
