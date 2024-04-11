package org.example;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Basic personBasic = new Basic(2.99);
        personBasic.consultaDeSaldo();
        personBasic.transactionOk();

        personBasic.retiroEfectivo(1.99);

        Cobrador cobrador = new Cobrador(4.99);
        cobrador.consultaDeSaldo();
    }
}
