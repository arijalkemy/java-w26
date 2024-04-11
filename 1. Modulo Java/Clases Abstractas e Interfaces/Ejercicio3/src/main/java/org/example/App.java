package org.example;

import org.example.animales.Gato;
import org.example.animales.Perro;
import org.example.animales.Vaca;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Perro perro = new Perro();
        Gato gato = new Gato();
        Vaca vaca = new Vaca();

        perro.emitirSonido();
        perro.comerCarne();

        gato.emitirSonido();
        gato.comerCarne();

        vaca.emitirSonido();
        vaca.comerHierba();
    }
}
