package org.example.ejercicio1.transaccion;

public class Deposito implements ITransaccion {
    @Override
    public void transaccionOK() {
        System.out.println("Realizando deposito");
    }

    @Override
    public void transaccionNoOK() {
        System.out.println("No se puede realizar el deposito");
    }
}
