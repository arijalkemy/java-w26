package ej1.modelo.transacciones;

import ej1.interfaces.ITransaccion;

public class ConsultaDeSaldo implements ITransaccion {
    @Override
    public void transaccionOk() {
        System.out.println("Consulta de saldo realizada con exito");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Consulta de saldo no realizada con exito");
    }
}
