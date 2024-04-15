package org.example.ejercicio1;

public class Transferencia implements ITransaccion{
    @Override
    public void transaccionOk() {
        System.out.println("Transacción realizada con exito");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Transaccion NO realizada");
    }
}
