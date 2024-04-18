package org.example;

import org.example.entity.Basic;
import org.example.entity.Cobradores;
import org.example.entity.Ejecutivos;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Cobradores cobrador = new Cobradores(2);
        System.out.println("Cobrador");
        cobrador.transaccionOk();
        cobrador.transaccionNoOk();
        System.out.println("Basic");
        Basic basic = new Basic(3);
        basic.transaccionOk();
        basic.transaccionNoOk();
        System.out.println("Ejecutivo");
        Ejecutivos ejecutivo = new Ejecutivos(2);
        ejecutivo.transaccionOk();
        ejecutivo.transaccionNoOk();
    }
}
