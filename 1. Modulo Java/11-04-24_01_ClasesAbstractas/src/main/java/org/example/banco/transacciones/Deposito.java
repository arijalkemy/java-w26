package org.example.banco.transacciones;

import org.example.banco.Transaccion;

public class Deposito implements Transaccion {
    @Override
    public void transaccionOk() {
        System.out.println("Realizándose depósito");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Depósito fallido");
    }
}

