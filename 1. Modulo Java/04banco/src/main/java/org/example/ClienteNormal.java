package org.example;

public abstract class ClienteNormal {
    public void consultarSaldo(ITransaccion transaccion) {
        System.out.println("Consultando saldo");
        transaccion.transaccionOk();
    }

    public void retirarEfectivo(ITransaccion transaccion) {
        System.out.println("Retirando efectivo");
        transaccion.transaccionNoOk();
    }
}

