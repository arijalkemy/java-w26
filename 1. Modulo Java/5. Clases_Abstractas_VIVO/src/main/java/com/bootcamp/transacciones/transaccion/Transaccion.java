package com.bootcamp.transacciones.transaccion;

public interface Transaccion {
    void transaccionOk(String tipoTransaccion);
    void transaccionNoOk(String tipoTransaccion);
}
