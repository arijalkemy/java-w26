package org.meli.ejercicio1;
import org.meli.ejercicio1.clases.*;
/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Prueba prueba = new Prueba();
        System.out.println( "Este es mi valor actual prueba 1 = "+prueba.miNumber);
        prueba.establecerContador(1);
        prueba.miNumber = prueba.siguienteNumero().intValue();
        System.out.println( "Este es mi valor despues de establecer el contador prueba 1 = "+prueba.miNumber);
        prueba.miNumber = prueba.siguienteNumero().intValue();
        System.out.println( "Este es mi valor despues de la siguiente iteracion prueba 1 = "+prueba.miNumber);
        Prueba2 prueba2 = new Prueba2();
        System.out.println( "Este es mi valor actual prueba 2 = "+prueba2.miNumber);
        prueba2.miNumber = prueba2.siguienteNumero().doubleValue();
        System.out.println( "Este es mi valor despues de la siguiente iteracion prueba 2 = "+prueba2.miNumber);

    }
}
