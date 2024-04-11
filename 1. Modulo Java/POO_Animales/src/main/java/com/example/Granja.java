package com.example;

public class Granja {
    public void comerAnimal(Animal animal){
        if(animal instanceof Carnivoro){
            ((Carnivoro) animal).comerCarne();
        }
        else{
            ((Herviboro) animal).comerHierba();
        }
    }
}
