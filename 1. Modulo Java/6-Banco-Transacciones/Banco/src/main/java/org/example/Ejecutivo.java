package org.example;

public class Ejecutivo extends Cliente{
    public void deposito() {
        super.getDeposito().TransaccionOk();
    }
    public void transferencia() {
        super.getTransferencias().TransaccionOk();
    }
}
