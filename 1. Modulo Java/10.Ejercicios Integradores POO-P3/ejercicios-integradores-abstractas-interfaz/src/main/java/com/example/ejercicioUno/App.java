package com.example.ejercicioUno;

import com.example.ejercicioUno.Clients.BasicClient;
import com.example.ejercicioUno.Clients.CollectorClient;
import com.example.ejercicioUno.Clients.ExecutiveClient;

public class App{

    public static void main(String[] args) {
        
        BasicClient basicClient = new BasicClient();
        CollectorClient collectorClient = new CollectorClient();
        ExecutiveClient executiveClient = new ExecutiveClient();


        // Transacciones cliente básico
        basicClient.checkBalanceOk();
        basicClient.checkBalanceNotOk();

        basicClient.servicePaymentOk();
        basicClient.servicePaymentOk();

        basicClient.withdrawOk();
        basicClient.withdrawNotOk();

        // Transacciones cliente ejecutivo
        executiveClient.depositOk();
        executiveClient.depositNotOk();

        executiveClient.transferOk();
        executiveClient.transferNotOk();

        // Transacciones cliente cobrador
        collectorClient.checkBalanceOk();
        collectorClient.checkBalanceNotOk();

        collectorClient.withdrawOk();
        collectorClient.withdrawNotOk();

    }



}
