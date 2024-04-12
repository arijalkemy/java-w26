package org.ejerciciouno.entities.financieros;

import org.ejerciciouno.interfaces.ITransaccion;

public class RetiroDeEfectivo implements ITransaccion {
    @Override
    public void transaccionOk() {
        System.out.println("Retiro de efectivo Ok");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Retiro de efectivo No Ok");
    }
}
