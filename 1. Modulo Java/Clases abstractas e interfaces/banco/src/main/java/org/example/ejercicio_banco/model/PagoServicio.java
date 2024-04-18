package org.example.ejercicio_banco.model;

import org.example.ejercicio_banco.ITransaccion;

public class PagoServicio implements ITransaccion {
    @Override
    public String transaccionOk() {
        return "Pago de servicio exitoso";
    }

    @Override
    public String transaccionNoOk() {
        return "Pago de servicio no exitoso";
    }
}
