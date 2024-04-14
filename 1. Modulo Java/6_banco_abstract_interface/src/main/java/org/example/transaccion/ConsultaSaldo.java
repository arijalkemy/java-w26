package org.example.transaccion;

public interface ConsultaSaldo extends ITransaccion {

    // Hago esta con default para practicar
    default void consultarSaldo() {
        System.out.println("Consultando saldo...");
    }

}
