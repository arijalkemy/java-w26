package com.meli;

public class Cobradores implements ITransaccion {
    @Override
    public void TransaccionOk() {
        System.out.println("Transacción Exitosa");
    }

    @Override
    public void TransaccionNoOk() {
        System.out.println("Transacción Fallida");
    }

    public void consultarSaldo()
    {
        System.out.println("Saldo consultado");
    }

    public void retiro()
    {
        System.out.println("Retiro realizado");
    }
}
