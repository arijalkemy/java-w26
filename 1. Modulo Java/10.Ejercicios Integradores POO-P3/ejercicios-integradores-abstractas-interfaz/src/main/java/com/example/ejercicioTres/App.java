package com.example.ejercicioTres;

import com.example.ejercicioTres.Animal.Cat;
import com.example.ejercicioTres.Animal.Cow;
import com.example.ejercicioTres.Animal.Dog;

public class App {

    public static void main(String[] args) {
        
        Cat cat = new Cat("Miel", 1);
        Dog dog = new Dog("Milo", 5);
        Cow cow = new Cow("Vaquita", 10);

        cat.makeSound();
        cat.eatMeat();

        dog.makeSound();
        dog.eatMeat();

        cow.eatHerb();
        cow.makeSound();
    }
}
