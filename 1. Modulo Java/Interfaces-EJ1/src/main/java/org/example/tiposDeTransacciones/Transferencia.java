package org.example.tiposDeTransacciones;

public interface Transferencia extends Transaccion {

    public void realizarTransacccion(int money, String numCuenta);
}
