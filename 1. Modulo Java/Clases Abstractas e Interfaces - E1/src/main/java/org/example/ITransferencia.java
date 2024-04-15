package org.example;

public interface ITransferencia extends ITransaccion {
    @Override
    default void transaccionOk() {
        System.out.println("Transferencia realizada correctamente");
    }

    @Override
    default void transaccionNoOk() {
        System.out.println("Transferencia no realizada correctamente");
    }
}
