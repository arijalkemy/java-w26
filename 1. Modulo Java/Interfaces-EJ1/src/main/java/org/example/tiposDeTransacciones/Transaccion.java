package org.example.tiposDeTransacciones;

public interface Transaccion {
    default boolean transaccionOK() {
        return true;
    }

    default boolean transaccionNoOk() {
        return false;
    }
}
