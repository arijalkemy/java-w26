package org.example;

public class App 
{
    public static void main( String[] args )
    {
        Basic basic = new Basic(1);
        basic.transaccionOk();

        Cobrador cobrador = new Cobrador(1);
        cobrador.transaccionOk();

        Ejecutivo ejecutivo = new Ejecutivo(1);
        ejecutivo.transaccionOk();
    }
}
