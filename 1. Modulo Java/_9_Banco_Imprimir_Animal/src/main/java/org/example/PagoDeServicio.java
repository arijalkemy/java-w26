package org.example;

public class PagoDeServicio implements ITransaccion{

    @Override
    public void transaccionOk() {
        System.out.println("Se realizo el pago de servicio");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("No se realizo el pago de servicio");

    }
}
