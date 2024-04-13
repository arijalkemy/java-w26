package org.example.ejercisio_3.animales;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Animal> animals = new ArrayList<Animal>(){{
            add(new Vaca());
            add(new Gato());
            add(new Perro());
        }};
        
        for (Animal animal : animals) {
            Animal.comerAnimal(animal);
            animal.emitirSonido();
        }

    }
}
