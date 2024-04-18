package org.example.entity;

import org.example.ITransaccion;

public class Basic implements ITransaccion {
    private int tipoTransaccion;

    public Basic(int tipoTransaccion) {
        this.tipoTransaccion = tipoTransaccion;
    }

    @Override
    public void transaccionOk() {
        switch (tipoTransaccion) {
            case 1:
                System.out.println("Consulta de saldo OK");
                break;
            case 2:
                System.out.println("Pado de servicio OK");
                break;
            case 3:
                System.out.println("Retiro de efectivo OK");
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
                System.out.println("Consulta de saldo no OK");
                break;
            case 2:
                System.out.println("Pado de servicio no OK");
                break;
            case 3:
                System.out.println("Retiro de efectivo no OK");
                break;
            default:
                System.out.println("Transaccion no reconocida");
                break;
        }
    }
}
