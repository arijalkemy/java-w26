package org.example;

import Clases.Animal;
import Clases.Gato;
import Clases.Perro;

import java.util.HashMap;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Animal animal = new Animal("inexistente");
        animal.mostrarEspecie();
        animal.hacerSonido();

        Perro perro = new Perro("canino", "Paquito");
        perro.hacerSonido();
        perro.mostrarEspecie();
        perro.mostrarNombre();

        Animal gato = new Gato("felino", "Teo");
        gato.mostrarEspecie();
        gato.hacerSonido();

        Animal animal1 = perro;
        animal1.hacerSonido();
        animal1.mostrarEspecie();

        System.out.println("La clase animal1 es de tipo: " + animal1.getClass());
    }
}
