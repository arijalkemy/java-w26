package org.example;

public class PagoServicios implements Transaccion{
    @Override
    public void TransaccionOk() {
        System.out.println("Pago exitoso");
    }

    @Override
    public void TransaccionNoOk() {
        System.out.println("Pago no exitoso");
    }
}
