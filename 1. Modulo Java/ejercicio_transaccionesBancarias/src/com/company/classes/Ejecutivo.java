package com.company.classes;

import com.company.interfaces.IDeposito;
import com.company.interfaces.ITransferencia;

public class Ejecutivo implements IDeposito, ITransferencia {
    @Override
    public void realizarDeposito() {
        System.out.println("Realizándose depósito.");
    }

    @Override
    public void transaccionOk() {
        System.out.println("Transacción ok.");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Transacción no ok.");
    }

    @Override
    public void realizarTransferencia() {
        System.out.println("Realizándose transferencia.");
    }
}
