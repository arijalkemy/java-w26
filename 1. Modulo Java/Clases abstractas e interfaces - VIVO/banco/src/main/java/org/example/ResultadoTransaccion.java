package org.example;

public interface ResultadoTransaccion {
    default void transaccionOk(){
        System.out.println("Transacción exitosa");
    }
    default void transaccionNoOk(){
        System.out.println("Transacción fallida");
    };
}
