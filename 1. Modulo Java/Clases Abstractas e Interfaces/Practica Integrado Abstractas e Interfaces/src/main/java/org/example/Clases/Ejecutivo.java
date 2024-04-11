package org.example.Clases;

import org.example.Interfaces.Deposito;
import org.example.Interfaces.Transferencia;

public class Ejecutivo implements Deposito, Transferencia {

    @Override
    public void RealizarDeposito() {
        System.out.println("Se realizo el deposito, desde ejecutivo");
    }
    @Override
    public void transaccionOk() {
        System.out.println("Transaccion Ok, desde ejecutivo");
    }
    @Override
    public void transaccionNoOk() {
        System.out.println("Transaccion NoOk, desde ejecutivo");
    }
    @Override
    public void realizarTransferencia() {
        System.out.println("Se realizo la transferencia, desde ejecutivo");
    }
}
