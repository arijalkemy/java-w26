package org.example.cliente;

import org.example.transaccion.Deposito;
import org.example.transaccion.Transferencia;

public class Ejecutivo implements Deposito, Transferencia {
    @Override
    public void realizarDeposito() {
        System.out.println("Deposito realizado");
    }

    @Override
    public void transaccionOk() {
        System.out.println("Transaccion ok");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Error en la transaccion");
    }

    @Override
    public void realizarTransferencia() {
        System.out.println("Transferencia realizada");
    }
}
