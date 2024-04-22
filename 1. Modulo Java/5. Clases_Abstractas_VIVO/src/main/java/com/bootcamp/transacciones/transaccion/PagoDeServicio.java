package com.bootcamp.transacciones.transaccion;

public interface PagoDeServicio extends Transaccion {
    void pagarServicio(String servicio, double monto);
}
