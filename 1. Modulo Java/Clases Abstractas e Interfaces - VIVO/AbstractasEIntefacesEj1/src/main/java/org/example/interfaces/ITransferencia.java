package org.example.interfaces;

public interface ITransferencia extends ITransaccion {
    void realizarTransferencia(String destinatario, int monto);
}
