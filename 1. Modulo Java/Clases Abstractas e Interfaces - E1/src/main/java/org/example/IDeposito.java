package org.example;

public interface IDeposito extends ITransaccion{
    @Override
    default void transaccionOk() {
        System.out.println("Deposito realizado correctamente");
    }

    @Override
    default void transaccionNoOk() {
        System.out.println("Deposito no realizado");
    }
}
