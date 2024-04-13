package org.example.ejercisio_1.transaccion;

public interface RetiroDeEfectivo extends Transaccion {
    default void retirarEfectivo(double efectivo, boolean estado){
        System.out.println(estado ? "Realizo un retiro por: " + efectivo : "retiro fallido");
    }
}
