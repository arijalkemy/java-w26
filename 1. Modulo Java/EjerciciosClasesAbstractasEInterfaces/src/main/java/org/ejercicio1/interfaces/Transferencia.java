package org.ejercicio1.interfaces;

public interface Transferencia extends ITransaccion {
    void trasnferir(double monto, String cuentaDestino);
}
