package org.ejerciciouno.entities.financieros;

import org.ejerciciouno.interfaces.ITransaccion;

public class ConsultaDeSaldo implements ITransaccion {
    @Override
    public void transaccionOk() {
        System.out.println("Consulta de saldo OK");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Consulta de saldo no OK");
    }
}
