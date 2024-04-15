package org.example.ejercicio_1;

public class PagoDeServicios implements ITransaccion {
    @Override
    public void transaccionOk() {
        System.out.println("Pago de Servicios OK");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Pago de Servicios No OK");
    }
}
