package com.example.ejercicioUno.Transactions;

import com.example.ejercicioUno.Interfaces.ITransaction;

public class Deposit implements ITransaction {
    @Override
    public void transactionOk() {
        System.out.println("El depósito se realizó de manera exitosa");
    }

    @Override
    public void transactionNotOK() {
        System.out.println("El depósito no se realizó de manera exitosa");
    }
}
