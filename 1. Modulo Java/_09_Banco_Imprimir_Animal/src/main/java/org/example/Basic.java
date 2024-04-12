package org.example;

public class Basic {
    public void consultarSaldo(ITransaccion transaccion){
        transaccion.transaccionOk();
    }

    public void pagoServicios(ITransaccion transaccion){
        transaccion.transaccionOk();
    }

    public void retiroEfectivo(ITransaccion transaccion){
        transaccion.transaccionOk();
    }
}
