package org.example;

public class UserEjecutive implements IDeposito, ITransferencias {

    @Override
    public void hacerDeposito() {
        System.out.println("Realizar deposito");
    }

    @Override
    public void realizarTransferencia() {
        System.out.println("Realizar transferencia");
    }
}
