package org.example.tiposDeTransacciones;

public interface ITransferencia extends ITransaccion {

    public void realizarTransacccion(int money, String numCuenta);
}
