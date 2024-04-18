package org.example.ejercicio_banco.model;


import org.example.ejercicio_banco.ITransaccion;

public class ConsultaSaldo implements ITransaccion {

    @Override
    public String transaccionOk() {
        return "Consulta saldo exitosa";
    }

    @Override
    public String transaccionNoOk() {
        return "Consulta saldo no exitosa";
    }
}
