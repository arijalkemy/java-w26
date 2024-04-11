package org.example;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Gato gato = new Gato();
        Perro perro = new Perro();
        Vaca vaca= new Vaca();

        gato.emitirSonido();
        gato.ComerCarne();

        perro.emitirSonido();
        perro.ComerCarne();

        vaca.emitirSonido();
        vaca.comerHierva();
    }
}
