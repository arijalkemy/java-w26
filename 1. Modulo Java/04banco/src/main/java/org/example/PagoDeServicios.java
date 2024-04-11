package org.example;

public class PagoDeServicios implements ITransaccion {

    @Override
    public void transaccionOk() {
        System.out.println("Pago de Servicios Ok");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Pago de Servicios No Ok");
    }
}

