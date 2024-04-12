package ej1.modelo.transacciones;

import ej1.interfaces.ITransaccion;

public class PagoDeServicios implements ITransaccion {
    @Override
    public void transaccionOk() {
        System.out.printf("Pago de servicio realizado con exito");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Pago de servicio realizado con exito");
    }
}
