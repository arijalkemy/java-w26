package org.example.Ejercicio1;

public class Ejecutivo extends Cliente{
    //Ejecutivos: Realizan Depósitos y Transferencias.
    @Override
    void realizarTransaccion(Transaccion transaccion) {
    if (transaccion instanceof Deposito ||transaccion instanceof Tranferencia){
        transaccion.transaccionOk();
    }else {
        transaccion.transaccionNoOk();
    }
    }
}
