package org.example;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Vaca vaca = new Vaca();
        vaca.emitirSonido();
        vaca.comer();
        Perro perro = new Perro();
        perro.emitirSonido();
        perro.comer();
        Gato gato = new Gato();
        gato.emitirSonido();
        gato.comer();
    }
}
