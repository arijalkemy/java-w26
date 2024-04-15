package org.example;

public interface IRetiroEfectivo extends ITransaccion{
    @Override
    default void transaccionOk() {
        System.out.println("Retiro de efectivo realizado correctamente");
    }

    @Override
    default void transaccionNoOk() {
        System.out.println("Retiro de efectivo no realizado");
    }
}
