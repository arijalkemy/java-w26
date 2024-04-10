package org.example;

import bootcamp.Animal;
import bootcamp.Gato;
import bootcamp.Perro;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Animal perro = new Perro("perro", "scooby");
        perro.mostrarEspecie();
        perro.hacerSonido();

        Gato gato = new Gato("Gato", "Poker");
        gato.mostrarEspecie();
        gato.hacerSonido();

        Animal animal = perro;
        animal.mostrarEspecie();
        animal.hacerSonido();
    }
}
