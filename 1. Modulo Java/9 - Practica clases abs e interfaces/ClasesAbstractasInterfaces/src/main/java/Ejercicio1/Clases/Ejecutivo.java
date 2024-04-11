package org.example.Clases;

import org.example.Interfaces.Deposito;
import org.example.Interfaces.Transferencia;

public class Ejecutivo implements Deposito, Transferencia {

    public void RealizarDeposito() {
        System.out.println("Se realizo el deposito, desde ejecutivo");
    }

    public void transaccionOk() {
        System.out.println("Transaccion Ok, desde ejecutivo");
    }

    public void transaccionNoOk() {
        System.out.println("Transaccion NoOk, desde ejecutivo");
    }

    public void realizarTransferencia() {
        System.out.println("Se realizo la transferencia, desde ejecutivo");
    }
}
