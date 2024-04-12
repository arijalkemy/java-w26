package ej1.modelo.transacciones;

import ej1.interfaces.ITransaccion;

public class Transferencia implements ITransaccion {
    @Override
    public void transaccionOk() {
        System.out.println("Transferencia realizada con exito");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Transferencia no realizada con exito");
    }
}
