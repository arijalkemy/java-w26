package org.ggomezr;

public class Ejecutivo extends Cliente{
    public void depositar(){
        System.out.println("Deposito realizado");
        transaccionOk();
    }

    public void transferir(){
        System.out.println("Transferencia realizada");
        transaccionOk();
    }
}
