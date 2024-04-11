package org.example.ejercisio_3;

import org.example.ejercisio_3.animales.Animal;
import org.example.ejercisio_3.animales.Gato;
import org.example.ejercisio_3.animales.Perro;
import org.example.ejercisio_3.animales.Vaca;

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
