package org.example;

public class App 
{
    public static void main( String[] args )
    {
        Ejecutivo ejecutivo = new Ejecutivo();
        Basic basic = new Basic();
        Cobrador cobrador = new Cobrador();

        System.out.println(ejecutivo.depositar().transaccionOk());
        System.out.println(ejecutivo.depositar().transaccionNoOk());
        System.out.println(ejecutivo.transferir().transaccionOk());
        System.out.println(ejecutivo.transferir().transaccionNoOk());

        System.out.println(basic.getConsultaSaldo().transaccionOk());
        System.out.println(basic.getConsultaSaldo().transaccionNoOk());
        System.out.println(basic.getPagoServicios().transaccionOk());
        System.out.println(basic.getPagoServicios().transaccionNoOk());
        System.out.println(basic.getRetiroEfectivo().transaccionOk());
        System.out.println(basic.getRetiroEfectivo().transaccionNoOk());

        System.out.println(cobrador.getConsultaSaldo().transaccionOk());
        System.out.println(cobrador.getConsultaSaldo().transaccionNoOk());
        System.out.println(cobrador.getRetiroEfectivo().transaccionOk());
        System.out.println(cobrador.getRetiroEfectivo().transaccionNoOk());

    }
}
