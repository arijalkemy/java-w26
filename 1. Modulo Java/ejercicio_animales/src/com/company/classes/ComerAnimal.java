package com.company.classes;

import com.company.interfaces.IComerAnimal;

public class ComerAnimal implements IComerAnimal<Animal> {
    @Override
    public void comerAnimal(Animal animal) {
        if(animal instanceof Perro){
            System.out.println("El perro está comiendo carne.");
        }
        if(animal instanceof Gato){
            System.out.println("El gato está comiendo carne.");
        }
        if(animal instanceof Vaca){
            System.out.println("La vaca está comiendo hierba");
        }
    }
}
