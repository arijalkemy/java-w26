package com.example.ejercicioUno.Clients;

import com.example.ejercicioUno.Transactions.ClientTransaction;

public class CollectorClient extends ClientTransaction{
    public void withdrawOk(){
        ClientTransaction.withdraw.transactionOk();
    }
    public void withdrawNotOk(){
        ClientTransaction.withdraw.transactionNotOK();
    }

    public void checkBalanceOk(){
        ClientTransaction.checkBalance.transactionOk();
    }
    public void checkBalanceNotOk(){
        ClientTransaction.checkBalance.transactionNotOK();
    }
}
