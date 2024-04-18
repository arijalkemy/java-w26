package org.example.ejercicio_banco.model;


import org.example.ejercicio_banco.ITransaccion;

public class Transferencia implements ITransaccion {

    @Override
    public String transaccionOk() {
        return "Transferencia exitosa";
    }

    @Override
    public String transaccionNoOk() {
        return "Transferencia no exitosa";
    }
}
