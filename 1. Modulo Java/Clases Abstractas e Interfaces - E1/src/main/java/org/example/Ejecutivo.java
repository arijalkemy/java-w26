package org.example;

public class Ejecutivo implements IDeposito, ITransferencia{
    private final int DEPOSITO = 1;
    private final int TRANSFERENCIA = 2;

    private int transaccion;

    public Ejecutivo(int transaccion) {
        this.transaccion = transaccion;
    }

    @Override
    public void transaccionOk() {
        if(transaccion == TRANSFERENCIA)
                IDeposito.super.transaccionOk();
        else if (transaccion == DEPOSITO)
            ITransferencia.super.transaccionOk();
        else
            System.out.println("Transacción inválida");
    }

    @Override
    public void transaccionNoOk() {
        if(transaccion == TRANSFERENCIA)
            IDeposito.super.transaccionNoOk();
        else if (transaccion == DEPOSITO)
            ITransferencia.super.transaccionNoOk();
        else
            System.out.println("Transacción inválida");
    }
}
