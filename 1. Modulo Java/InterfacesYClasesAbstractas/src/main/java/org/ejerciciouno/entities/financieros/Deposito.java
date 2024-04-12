package org.ejerciciouno.entities.financieros;

import org.ejerciciouno.interfaces.ITransaccion;

public class Deposito implements ITransaccion {
    @Override
    public void transaccionOk() {
        System.out.println("Deposito OK");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Deposito No OK");
    }
}
