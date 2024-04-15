package org.example.ejercicio_1;

public class RetiroDeEfectivo implements ITransaccion {
    @Override
    public void transaccionOk() {
        System.out.println("Retiro de Efectivo OK");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Retiro de Efectivo No OK");
    }
}
