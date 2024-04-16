package org.example.model;

public class Basic extends Cliente{
    @Override
    void realizarTransaccion(Transaccion transaccion) {
        if (transaccion instanceof ConsultaDeSaldo || transaccion instanceof PagoDeServicio || transaccion instanceof RetiroDeEfectivo){
            transaccion.transaccionOk();
        }
        else {
            transaccion.transaccionNoOk();
        }
    }
}
