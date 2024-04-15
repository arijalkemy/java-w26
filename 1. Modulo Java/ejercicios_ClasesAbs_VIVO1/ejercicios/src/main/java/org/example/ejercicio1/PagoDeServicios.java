package org.example.ejercicio1;

public class PagoDeServicios implements ITransaccion{
    @Override
    public void transaccionOk() {
        System.out.println("Pago de servicios realizado con exito");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Pago de servicios NO realizado");
    }
}
