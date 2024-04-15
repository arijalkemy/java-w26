package org.example;

public class Ejecutivo implements TransaccionesEjecutivos, ResultadoTransaccion {

    @Override
    public void depositos() {
        System.out.println("realizando deposito");
        try {
            transaccionOk();
        } catch (Exception e) {
            transaccionNoOk();
        }
    }

    @Override
    public void transferencias() {
        System.out.println("realizando transferencia");
        try {
            transaccionOk();
        } catch (Exception e) {
            transaccionNoOk();
        }
    }

}
