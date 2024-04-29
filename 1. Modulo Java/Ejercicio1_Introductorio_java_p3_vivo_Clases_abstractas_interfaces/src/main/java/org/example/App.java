package org.example;

import logica.Basic;
import logica.Cobrador;
import logica.Ejecutivo;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

        System.out.println( "Aplicacion transfeencia bancaria" );
        System.out.println( "................................." );
        System.out.println( "Usuario: Basico" );
        Basic basic = new Basic();
        basic.realizarConsultaDeSaldo();
        basic.realizarDeposito();
        System.out.println( "................................." );
        System.out.println( "Usuario: Cobrador" );
        Cobrador cobrador = new Cobrador();
        cobrador.realizarConsultaDeSaldo();
        cobrador.realizarDeposito();
        System.out.println( "................................." );
        System.out.println( "Usuario: Ejecutivo" );
        Ejecutivo ejecutivo = new Ejecutivo();
        ejecutivo.realizarConsultaDeSaldo();
        ejecutivo.realizarDeposito();
    }
}
