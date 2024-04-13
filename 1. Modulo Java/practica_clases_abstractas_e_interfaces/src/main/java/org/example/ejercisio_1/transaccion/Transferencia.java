package org.example.ejercisio_1.transaccion;

public interface Transferencia extends Transaccion{
    default void estadoTransaccion(boolean estado){
        System.out.println("La transferencia fue" + (estado ? " exitosa" : " fallida"));
    };
}
