package org.example;

import org.example.interfaces.IConsultaDeSaldo;
import org.example.interfaces.IPagoDeServicios;
import org.example.interfaces.IRetiroDeEfectivo;

public class Basic implements IConsultaDeSaldo, IPagoDeServicios, IRetiroDeEfectivo {

    @Override
    public void consultarSaldo() {
        System.out.println("Consultando saldo");
        transaccionOk("Consulta de saldo");
    }

    @Override
    public void pagarServicio(String servicio) {
        System.out.println("pagando servicio : " + servicio);
        transaccionNoOk("pago de servicio");
    }

    @Override
    public void retirarEfectivo(int monto) {
        System.out.println("retirando: " + monto);
        transaccionOk("retiro de efectivo");
    }

    @Override
    public void transaccionOk(String tipoDeTransaccion) {
        System.out.println("Cliente Basic, transaccion " + tipoDeTransaccion + " realizada correctamente");
    }

    @Override
    public void transaccionNoOk(String tipoDeTransaccion) {
        System.out.println("Cliente Basic, transaccion " + tipoDeTransaccion + " no se realizo correctamente");
    }

}
