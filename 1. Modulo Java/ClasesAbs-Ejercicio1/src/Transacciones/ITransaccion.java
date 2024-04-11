package Transacciones;

public interface ITransaccion {
    default void transaccionOk() {
        System.out.println("El cliente realizo la transaccion con exito!");
    }

    default void transaccionNoOk() {
        System.out.println("El cliente no pudo realizar la transaccion!");
    }
}
