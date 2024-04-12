package com.example.ejercicioUno.Transactions;

import com.example.ejercicioUno.Interfaces.ITransaction;

public class ServicePayment implements ITransaction{

    @Override
    public void transactionOk() {
        System.out.println("El pago de servicios se completó de manera satisfactoria");
    }

    @Override
    public void transactionNotOK() {
        System.out.println("El pago de servicios no se completó de manera satisfactoria");
    }

}
