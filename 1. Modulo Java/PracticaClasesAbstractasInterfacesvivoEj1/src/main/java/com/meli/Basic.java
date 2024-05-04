package com.meli;

public class Basic implements ITransaccion {
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

    public void pagosDeServicios()
    {
        System.out.println("Pago de servicios realizado");
    }
}
