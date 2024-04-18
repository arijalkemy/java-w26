package org.example.entity;

import org.example.ITransaccion;

public class Cobradores implements ITransaccion {
    private int tipoTransaccion;

    public Cobradores(int tipoTransaccion) {
        this.tipoTransaccion = tipoTransaccion;
    }

    @Override
    public void transaccionOk() {
        switch (tipoTransaccion) {
            case 1:
                System.out.println("Retiro de efectivo OK");
                break;
            case 2:
                System.out.println("Consulta de saldos OK");
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
                System.out.println("Retiro de efectivo no OK");
                break;
            case 2:
                System.out.println("Consulta de saldos no OK");
                break;
            default:
                System.out.println("Transaccion no reconocida");
                break;
        }
    }
}
