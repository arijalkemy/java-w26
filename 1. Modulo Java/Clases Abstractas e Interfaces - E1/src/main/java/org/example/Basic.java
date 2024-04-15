package org.example;

public class Basic implements IConsultaSaldo, IPagoServicios, IRetiroEfectivo{
    private final int CONSULTA = 1;
    private final int PAGO = 2;
    private final int RETIRO = 3;

    private int transaccion;

    public Basic(int transaccion) {
        this.transaccion = transaccion;
    }

    @Override
    public void transaccionOk() {
        if (transaccion == CONSULTA)
            IConsultaSaldo.super.transaccionOk();
        else if (transaccion == PAGO)
            IPagoServicios.super.transaccionOk();
        else if (transaccion == RETIRO)
            IRetiroEfectivo.super.transaccionOk();
        else
            System.out.println("Transacción inválida");
    }

    @Override
    public void transaccionNoOk() {
        if (transaccion == CONSULTA)
            IConsultaSaldo.super.transaccionNoOk();
        else if (transaccion == PAGO)
            IPagoServicios.super.transaccionNoOk();
        else if (transaccion == RETIRO)
            IRetiroEfectivo.super.transaccionNoOk();
        else
            System.out.println("Transacción inválida");
    }
}
