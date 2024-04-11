package org.example.AbstractClass_Interfaces.Ejercicio_1.Services;

public interface Transaccion {

    default void transaccionOk(){
        System.out.println("Transaccion realizada");
    }

    default void transaccionNoOk(){
        System.out.println("Transaccion no realizada");
    }
}
