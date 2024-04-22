package com.bootcamp.transacciones.transaccion;

public interface Transferencia extends Transaccion {
    void transferir(String cuentaOrigen, String cuentaDestino, double monto);
}
