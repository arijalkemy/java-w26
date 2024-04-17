package org.example;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Perro perro = new Perro();
        perro.comer();
        perro.emitirSonido();
        System.out.println("");

        Gato gato = new Gato();
        gato.comer();
        gato.emitirSonido();
        System.out.println("");

        Vaca vaca = new Vaca();
        vaca.comer();
        vaca.emitirSonido();

        comerAnimal(perro);
    }

    static void comerAnimal(Animal animal) {
        if (animal instanceof ICarnivoro) {
            ((ICarnivoro) animal).comer();
        } else if (animal instanceof IHervivoro) {
            ((IHervivoro) animal).comer();
        } else {
            System.out.println("No se puede determinar el tipo de alimentación del animal.");
        }
    }
}
