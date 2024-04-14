package org.example.tiposDeTransacciones;

public interface ITransaccion {
    default boolean transaccionOK() {
        return true;
    }

    default boolean transaccionNoOk() {
        return false;
    }
}
