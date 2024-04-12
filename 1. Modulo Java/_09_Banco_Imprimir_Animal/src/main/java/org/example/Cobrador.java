package org.example;

public class Cobrador {
    public void consultarSaldo(ITransaccion transaccion){
        transaccion.transaccionOk();
    }

    public void retiroEnEfectivo(ITransaccion transaccion){
        transaccion.transaccionOk();
    }
}
