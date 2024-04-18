package org.example.entity;

import org.example.ITransaccion;

public class Ejecutivos implements ITransaccion {
    private int tipoTransaccion;

    public Ejecutivos(int tipoTransaccion) {
        this.tipoTransaccion = tipoTransaccion;
    }

    @Override
    public void transaccionOk() {
        switch (tipoTransaccion) {
            case 1:
                System.out.println("Deposito OK");
                break;
            case 2:
                System.out.println("Transderencia OK");
                break;
            default:
                System.out.println("Transaccion no reconocida");
                break;
        }
    }

    @Override
    public void transaccionNoOk() {
        switch (tipoTransaccion) {
            case 1:
                System.out.println("Deposito no Ok");
                break;
            case 2:
                System.out.println("Transderencia no OK");
                break;
            default:
                System.out.println("Transaccion no reconocida");
                break;
        }
    }
}
