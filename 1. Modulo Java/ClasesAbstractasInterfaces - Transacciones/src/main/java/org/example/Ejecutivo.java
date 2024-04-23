package org.example;

public class Ejecutivo implements IDeposito, ITransferencia{

    public void depositar() {
        System.out.println("Deposito correcto");
    }

    public void transferir() {
        System.out.println("transferencia realizada");
    }

    public void transaccionOk() {
        System.out.println("transaccion ok");
    }

    public void transaccionNoOk() {
        System.out.println("error en transaccion");
    }
}
