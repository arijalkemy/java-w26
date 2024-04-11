package org.example;

public class ClienteEjecutivo {
    public void depositar(ITransaccion transaccion) {
        System.out.println("Cliente Ejecutivo Depositando");
        transaccion.transaccionNoOk();
    }

    public void transferir(ITransaccion transaccion) {
        System.out.println("Cliente Ejecutivo Transfiriendo");
        transaccion.transaccionOk();
    }
}
