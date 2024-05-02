package org.example;

public class Ejecutivos implements IDeposito, ITransferencia{
    public Ejecutivos() {
    }

    @Override
    public void transaccionOkD() {
        System.out.println("transaccion ok deposito");
    }

    @Override
    public void transaccionNoOkD() {
        System.out.println("transaccion no ok deposito");
    }

    @Override
    public void transaccionOkT() {
        System.out.println("transaccion ok transferencia");
    }

    @Override
    public void transaccionNoOkT() {
        System.out.println("transaccion no ok transferencia");
    }
}
