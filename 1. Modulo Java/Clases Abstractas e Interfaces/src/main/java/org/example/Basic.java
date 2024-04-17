package org.example;

public class Basic implements ITransacciones{

    @Override
    public void transaccionNoOk() {
        System.out.println("Transaccion no realizada");
    }

    @Override
    public void transaccionOK() {
        System.out.println("Transaccion realizada");
    }

    public void consultaSaldos(){
        System.out.println("Consultando saldo");
    }

    public void pagoDeServicio(){
        System.out.println("Pagando servicio");
    }

    public void retiroEfectivo(){
        System.out.println("Retirando efectivo");
    }

}
