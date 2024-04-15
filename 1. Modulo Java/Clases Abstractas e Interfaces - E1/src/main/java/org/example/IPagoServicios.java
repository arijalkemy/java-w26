package org.example;

public interface IPagoServicios extends ITransaccion{
    @Override
    default void transaccionOk() {
        System.out.println("Pago de servicios realizado correctamente");
    }

    @Override
    default void transaccionNoOk() {
        System.out.println("Pago de servicios no realizado");
    }
}
