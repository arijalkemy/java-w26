package org.example;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

        System.out.println("\nTransacciones Ejecutivos\n");
        Ejecutivos ejecutivo = new Ejecutivos();
        ejecutivo.transaccionOK();
        ejecutivo.deposito();
        ejecutivo.tranferencia();


        System.out.println("\nTransacciones Cobradores\n");
        Cobradores cobrador = new Cobradores();
        cobrador.consultaSaldos();
        cobrador.transaccionNoOk();
        cobrador.retiroEfectivo();


        System.out.println("\nTransacciones Basic\n");
        Basic basic = new Basic();
        basic.consultaSaldos();
        basic.retiroEfectivo();
    }
}
