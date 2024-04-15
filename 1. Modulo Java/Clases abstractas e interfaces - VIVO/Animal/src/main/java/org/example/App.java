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
        Vaca vaca = new Vaca();
        gato.emitirSonido();
        gato.comerCarne();
        perro.emitirSonido();
        perro.comerCarne();
        vaca.emitirSonido();
        vaca.comerHierba();

        Animal.comerAnimal(gato);;
        Animal.comerAnimal(perro);
        Animal.comerAnimal(vaca);
    }

}
