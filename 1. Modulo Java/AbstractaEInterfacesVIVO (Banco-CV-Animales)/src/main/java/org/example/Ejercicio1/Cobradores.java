package org.example.Ejercicio1;

public class Cobradores extends Cliente{
    //Cobradores: Realizan retiro de efectivo y consulta de saldos.
    @Override
    void realizarTransaccion(Transaccion transaccion) {
        if (transaccion instanceof RetiroDeEfectivo || transaccion instanceof ConsultaDeSaldo){
            transaccion.transaccionOk();
        }else {
            transaccion.transaccionNoOk();
        }
    }
}
