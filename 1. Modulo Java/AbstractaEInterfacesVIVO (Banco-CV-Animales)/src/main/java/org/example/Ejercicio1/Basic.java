package org.example.Ejercicio1;

public class Basic extends Cliente{
    //Basic: Realizan consultas de saldo, pagos de servicios y retiro de efectivo.
    @Override
    void realizarTransaccion(Transaccion transaccion) {
        if (transaccion instanceof ConsultaDeSaldo || transaccion instanceof RetiroDeEfectivo){
            transaccion.transaccionOk();
        }else {
            transaccion.transaccionNoOk();
        }
    }
}
