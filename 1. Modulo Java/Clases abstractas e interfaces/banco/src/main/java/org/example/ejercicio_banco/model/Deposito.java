package org.example.ejercicio_banco.model;

import org.example.ejercicio_banco.ITransaccion;

public class Deposito implements ITransaccion {

    @Override
    public String transaccionOk() {
        return "Deposito exitoso";
    }

    @Override
    public String transaccionNoOk() {
        return "Deposito no exitoso";
    }
}
