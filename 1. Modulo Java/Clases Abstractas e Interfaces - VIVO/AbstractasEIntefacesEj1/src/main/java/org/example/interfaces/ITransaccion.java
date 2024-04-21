package org.example.interfaces;

public interface ITransaccion {
    void transaccionOk(String tipoDeTransaccion);

    void transaccionNoOk(String tipoDeTransaccion);
}
