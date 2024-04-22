package com.bootcamp.transacciones.transaccion;

public interface RetiroDeEfectivo extends Transaccion {
    void retirar(String cuenta, double monto);
}
