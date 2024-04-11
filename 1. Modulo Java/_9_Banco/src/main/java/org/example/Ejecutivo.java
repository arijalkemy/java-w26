package org.example;

public class Ejecutivo {
    public void deposito(ITransaccion transaccion){
        transaccion.transaccionOk();
    }

    public void transferencia(ITransaccion transaccion){
        transaccion.transaccionOk();
    }
}
