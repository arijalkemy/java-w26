package org.example;

public class Basic implements Transaccion{
    @Override
    public void transaccionOk() {

        System.out.println("Basic: la transaccion fue ok");
    }

    @Override
    public void transaccionNoOk() {

        System.out.println("Basic: la transaccion fue no ok");
    }

    public void consultaDeSaldo(){
        System.out.println("Basic: consulta de saldo en proceso");
        transaccionNoOk();
    }

    public void pagoDeServicios(){

        System.out.println("Basic: pago de servicio en proceso");
        transaccionOk();
    }

    public void retiroDeEfectivo(){

        System.out.println("Basic: retiro de efectivo en proceso");
        transaccionOk();
    }
}
