package org.example;

public interface IConsultaSaldo extends ITransaccion {
    @Override
    default void transaccionOk() {
        System.out.println("Consulta de saldo realizada correctamente");
    }

    @Override
    default void transaccionNoOk() {
        System.out.println("Consulta de saldo no realizada");
    }
}
