package org.ejercicio1.interfaces;

public interface ITransaccion {
    default void transaccionOk(String transaccion){
        System.out.println("Transaccion " + transaccion + " realizada con exito");
    };
    default void transaccionNoOk(String transaccion){
        System.out.println("Transaccion " + transaccion + " rechazada");
    };
}
