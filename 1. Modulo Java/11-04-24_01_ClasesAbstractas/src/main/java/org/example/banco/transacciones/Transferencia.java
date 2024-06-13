package org.example.banco.transacciones;

import org.example.banco.Transaccion;

public class Transferencia implements Transaccion {
    @Override
    public void transaccionOk() {
        System.out.println("Realizándose transferencia");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Transferencia fallida");
    }
}