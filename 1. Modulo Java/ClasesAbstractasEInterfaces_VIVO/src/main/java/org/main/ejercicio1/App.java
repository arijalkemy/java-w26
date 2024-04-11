package org.main.ejercicio1;
import org.main.ejercicio1.entidades.*;
/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Basic clienteBasico = new Basic();
        Cobrador cobrador = new Cobrador();
        Ejecutivo ejecutivo = new Ejecutivo();

        System.out.println(clienteBasico.consultarSaldo());
        System.out.println(cobrador.consultarSaldo());
        System.out.println(ejecutivo.depositar(1000.0));

    }
}
