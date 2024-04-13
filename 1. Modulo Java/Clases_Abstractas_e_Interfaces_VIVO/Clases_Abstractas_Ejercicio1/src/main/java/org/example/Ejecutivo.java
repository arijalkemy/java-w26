package org.example;

public class Ejecutivo implements Deposito, Transferencia {

    public void hacerDeposito() {
        System.out.println("Intentando hacer depósito...");
    }

    public void hacerTransferencia() {
        System.out.println("Intentando hacer transferencia...");
    }

    @Override
    public void transaccionOk() {
        System.out.println("Transacción realizada correctamente");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("La transacción no se pudo concluir");
    }

}
