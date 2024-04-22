package com.bootcamp.transacciones.transaccion;

public interface Deposito extends Transaccion {
    void depositar(String cuenta, double monto);
}
