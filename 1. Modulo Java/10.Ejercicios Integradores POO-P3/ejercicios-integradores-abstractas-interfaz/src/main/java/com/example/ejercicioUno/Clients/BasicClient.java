package com.example.ejercicioUno.Clients;

import com.example.ejercicioUno.Transactions.ClientTransaction;

public class BasicClient extends ClientTransaction{

    public void checkBalanceOk(){
        ClientTransaction.checkBalance.transactionOk();
    }
    public void checkBalanceNotOk(){
        ClientTransaction.checkBalance.transactionNotOK();
    }
    
    public void servicePaymentOk(){
        ClientTransaction.servicePayment.transactionOk();
    }
    public void servicePaymentNotOk(){
        ClientTransaction.servicePayment.transactionNotOK();
    }

    public void withdrawOk(){
        ClientTransaction.withdraw.transactionOk();
    }
    public void withdrawNotOk(){
        ClientTransaction.withdraw.transactionNotOK();
    }
}
