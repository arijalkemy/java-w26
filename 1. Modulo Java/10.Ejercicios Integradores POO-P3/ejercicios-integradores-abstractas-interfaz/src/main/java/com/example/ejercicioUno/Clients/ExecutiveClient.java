package com.example.ejercicioUno.Clients;

import com.example.ejercicioUno.Transactions.ClientTransaction;

public class ExecutiveClient extends ClientTransaction{

    public void depositOk(){
        ClientTransaction.deposit.transactionOk();
    }
    public void depositNotOk(){
        ClientTransaction.deposit.transactionNotOK();
    }

    public void transferOk(){
        ClientTransaction.transfer.transactionOk();
    }
    public void transferNotOk(){
        ClientTransaction.transfer.transactionNotOK();
    }
}

