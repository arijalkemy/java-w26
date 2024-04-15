package org.example.clases;

import org.example.interfaces.Deposito;
import org.example.interfaces.Transferencia;

public class Ejecutivo implements Deposito, Transferencia {
    @Override
    public void transaccionOk() {
        System.out.println("¡Transacción realizada con exito!");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Transacción fallida :(");

    }

    @Override
    public void hacerDeposito() {
        System.out.println("Se está realizando un Deposito...");
    }

    @Override
    public void hacerTransferencia() {
        System.out.println("Se está realizando una Transferencia...");
    }
}
