package org.example;

import java.util.ArrayList;
import java.util.List;

public class App
{
    public static void main( String[] args ) {
        //Creo instancias para los animales
        Vaca vaca = new Vaca();
        Perro perro = new Perro();
        Gato gato = new Gato();

        //Creo una lista de todos los animales
        List<Animal> animales = new ArrayList<>();
        animales.add(vaca);
        animales.add(perro);
        animales.add(gato);

        //Recorro la lista con un for para aplicar acciones a cada animal
        for(Animal animal: animales){
            animal.emitirSonido();
            comerAnimal(animal);
        }
    }

    private static void comerAnimal(Animal animal){
        animal.comer();
    }
}
