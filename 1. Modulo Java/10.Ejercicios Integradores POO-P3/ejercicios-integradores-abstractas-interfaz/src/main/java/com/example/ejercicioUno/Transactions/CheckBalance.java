package com.example.ejercicioUno.Transactions;

import com.example.ejercicioUno.Interfaces.ITransaction;

public class CheckBalance implements ITransaction{

    @Override
    public void transactionOk(){
        System.out.println("La consulta de saldo se realizó satisfactoriamente");
    }

    @Override
    public void transactionNotOK(){
        System.out.println("La consulta de saldo no se realizó satisfactoriamente");
    }
}


