package org.example.ejercicio_1;

public class Transferencia implements ITransaccion {
    @Override
    public void transaccionOk() {
        System.out.println("Transferencia OK");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Transferencia No OK");
    }
}
