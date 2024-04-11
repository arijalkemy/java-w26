package org.ggomezr;

public class Basic extends Cliente{
    public void consultarSaldo(){
        System.out.println("Consulta de saldo realizada");
        transaccionOk();
    }

    public void pagarServicio(){
        System.out.println("Pago de servicio realizado");
        transaccionOk();
    }

    public void retirarEfectivo(){
        System.out.println("Retiro de efectivo realizado");
        transaccionOk();
    }
}
