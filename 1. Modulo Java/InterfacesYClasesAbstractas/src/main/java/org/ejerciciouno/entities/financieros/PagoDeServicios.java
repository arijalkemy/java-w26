package org.ejerciciouno.entities.financieros;

import org.ejerciciouno.interfaces.ITransaccion;

public class PagoDeServicios implements ITransaccion {
    @Override
    public void transaccionOk() {
        System.out.println("Pago de servicios Ok");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Pago de servicios No Ok");
    }
}
