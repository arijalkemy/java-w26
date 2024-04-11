package org.example.ejercisio_1.transaccion;

public interface Transaccion {
    static boolean transaccionOk(){return true;};
    static boolean transaccionNoOk(){return false;};
}
