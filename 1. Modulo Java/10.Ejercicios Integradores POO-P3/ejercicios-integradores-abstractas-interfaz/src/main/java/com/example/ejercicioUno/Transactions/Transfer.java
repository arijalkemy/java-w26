package com.example.ejercicioUno.Transactions;

import com.example.ejercicioUno.Interfaces.ITransaction;

public class Transfer implements ITransaction{
    @Override
    public void transactionOk(){
        System.out.println("La transferencia se realizó con éxito");
    }

    @Override
    public void transactionNotOK(){
        System.out.println("La transferencia no se realizó con éxito");
    }

}
