package org.example;

public class Cobrador implements Transaccion{
    @Override
    public void transaccionOk() {
        System.out.println("Cobrador: Transaccion Ok");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Cobrador: Transaccion Fallida.");
    }

    public void retiroDeEfectivo(){
        System.out.println("Cobrador: retiro de efectivo en proceso");
        transaccionNoOk();
    }
    public void consultaDeSaldo(){
        System.out.println("Cobrador: consulta de saldo en proceso");
        transaccionOk();
    }
}
