package org.example.acciones;

import org.example.interfaces.ITransaccion;

public class Saldo implements ITransaccion {

    public void transaccionOk() {
        System.out.println("Saldo actual : ");
    }

    public void transaccionNoOk() {
        System.out.println("Error al consultar el saldo");
    }
}
