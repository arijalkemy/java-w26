package org.example;

public class Cobrador implements IRetiroEfectivo,IConsultaSaldo{
    public void consultarSaldo() {
        System.out.println("su saldo es:");
    }

    public void retirarFt() {
        System.out.println("retirando..");
    }

    public void transaccionOk() {
        System.out.println("transaccion ok");
    }

    public void transaccionNoOk() {
        System.out.println("error en transaccion");
    }
}
