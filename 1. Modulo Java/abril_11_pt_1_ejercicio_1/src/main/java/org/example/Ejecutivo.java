package org.example;

public class Ejecutivo implements Transferencia, Deposito {

    @Override
    public void depositar() {
        System.out.println("Ejecutivo depositado");
    }

    @Override
    public void transferir() {
        System.out.println("Ejecutivo transferido");
    }

    @Override
    public void transaccionOk(String transaccion) {
        System.out.print("Transaccion Nook" + transaccion);
    }

    @Override
    public void transaccionNOk(String transaccion) {
        System.out.print("Transaccion OK" + transaccion);
    }
}
