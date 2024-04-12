package org.ejerciciouno.entities.financieros;

import org.ejerciciouno.interfaces.ITransaccion;

public class Transferencia implements ITransaccion {
    @Override
    public void transaccionOk() {
        System.out.println("Transferencia ok");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Transferencia no ok");
    }
}
