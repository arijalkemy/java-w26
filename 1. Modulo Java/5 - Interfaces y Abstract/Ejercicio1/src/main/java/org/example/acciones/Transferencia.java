package org.example.acciones;

import org.example.interfaces.ITransaccion;

public class Transferencia implements ITransaccion {
    public void transaccionOk() {
        System.out.println("La transferencia se realizo correctamente");
    }

    public void transaccionNoOk() {
        System.out.println("La transferencia no se realizo correctamente");
    }
}
