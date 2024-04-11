package org.main.ejercicio3;


import org.main.ejercicio3.clases.Animal;
import org.main.ejercicio3.clases.*;

/**
 * Hello world!
 *
 */
public class App
{
    public static void main( String[] args )
    {
        Gato gatito = new Gato();
        Perro perrito = new Perro();
        Vaca vaquita = new Vaca();

        gatito.hacersonido();
        perrito.hacersonido();
        vaquita.hacersonido();

        gatito.comerCarne();
        perrito.comerCarne();
        vaquita.comerHierba();
    }
}
