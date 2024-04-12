package com.example.ejercicioUno.Transactions;

import com.example.ejercicioUno.Interfaces.ITransaction;

public class Withdraw implements ITransaction{

    @Override
    public void transactionOk(){
        System.out.println("");
    }

    @Override
    public void transactionNotOK(){
        System.out.println("");
    }

}
