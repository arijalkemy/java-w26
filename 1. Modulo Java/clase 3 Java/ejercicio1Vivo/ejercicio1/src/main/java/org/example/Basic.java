package org.example;

public class Basic extends OperacionesBasicas implements Itransaccion {
    public Basic(double saldo) {
        super(saldo);
    }

    @Override
    public void transactionNoOk() {
        System.out.println("Transaction error");
    }

    @Override
    public void transactionOk() {
        System.out.println("Transaction ok");
    }

    public void pagoDeServicios(double cantidad, String empresa) {
        System.out.println("Pago de " + cantidad + " a la empresa " + empresa );
    }
}
