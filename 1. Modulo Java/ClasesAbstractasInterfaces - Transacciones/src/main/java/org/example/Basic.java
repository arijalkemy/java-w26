package org.example;

public class Basic implements  IConsultaSaldo, IPagoServicios,IRetiroEfectivo{
    public void consultarSaldo() {
        System.out.println("su saldo es: ");
    }

    public void pagarServicios() {
        System.out.println("pagando servicios");
    }

    public void retirarFt() {
        System.out.println("retiro de efectivo");
    }

    public void transaccionOk() {
        System.out.println("transaccion realizada");
    }

    public void transaccionNoOk() {
        System.out.println("error en transaccion");
    }
}
