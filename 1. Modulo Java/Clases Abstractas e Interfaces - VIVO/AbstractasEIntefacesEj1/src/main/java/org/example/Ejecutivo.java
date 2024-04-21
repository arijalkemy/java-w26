package org.example;

import org.example.interfaces.IDeposito;
import org.example.interfaces.ITransferencia;

public class Ejecutivo implements IDeposito, ITransferencia {


    @Override
    public void realizarDeposito(int monto) {
        System.out.println("realizando deposito por el monto: " + monto);
        transaccionOk("deposito");
    }

    @Override
    public void realizarTransferencia(String destinatario, int monto) {
        System.out.println("realizando transferencia a: " + destinatario + " por el monto de: " + monto);
        transaccionNoOk("transferencia");
    }

    @Override
    public void transaccionOk(String tipoDeTransaccion) {
        System.out.println("La " + tipoDeTransaccion + " se ha realizado correctamente");
    }

    @Override
    public void transaccionNoOk(String tipoDeTransaccion) {
        System.out.println("La " + tipoDeTransaccion + " no se ha podido realizar");
    }
}
