package org.ggomezr;

public class Cobrador extends Cliente{
    public void retiroEfectivo(){
        System.out.println("Retiro de efectivo realizado");
        transaccionOk();
    }

    public void consultarSaldo(){
        System.out.println("Consulta de saldo realizada");
        transaccionOk();
    }
}
