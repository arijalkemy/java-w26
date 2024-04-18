package org.example.ejercicio_banco.model;

import org.example.ejercicio_banco.ITransaccion;

public class RetiroEfectivo implements ITransaccion {

    @Override
    public String transaccionOk() {
        return "Retiro de efectivo exitoso";
    }

    @Override
    public String transaccionNoOk() {
        return "Retiro de efectivo no exitoso";
    }
}
