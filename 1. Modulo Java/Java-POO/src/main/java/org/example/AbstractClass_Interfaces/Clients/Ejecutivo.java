package org.example.AbstractClass_Interfaces.Clients;

import org.example.AbstractClass_Interfaces.Services.DepositosTransferencias;

public class Ejecutivo implements DepositosTransferencias {


    @Override
    public void deposito() {
        System.out.println("Deposito realizado");
    }

    @Override
    public void transferencia() {
        System.out.println("Transferencia realizada");
    }
}
