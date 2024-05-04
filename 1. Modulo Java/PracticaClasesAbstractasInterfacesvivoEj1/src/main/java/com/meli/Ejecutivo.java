package com.meli;

public class Ejecutivo implements ITransaccion {
    @Override
    public void TransaccionOk() {
        System.out.println("Transacción Exitosa");
    }

    @Override
    public void TransaccionNoOk() {
        System.out.println("Transacción Fallida");
    }
    public void deposito()
    {
        System.out.println("Deposito realizado");
    }
    public void transferencia()
    {
        System.out.println("Transferencia realizada");
    }

}
