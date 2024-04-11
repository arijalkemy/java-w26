package org.example.ejercicio1.transaccion;

public class PagoDeServicios implements ITransaccion {
    @Override
    public void transaccionOK() {
        System.out.println("Realizando pago de servicios");
    }

    @Override
    public void transaccionNoOK() {
        System.out.println("No se puede realizar el pago de servicio");
    }
}
