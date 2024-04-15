package org.example;

public abstract class Animal {
    public abstract void emitirSonido();

    public static void comerAnimal(Animal animal){
        if(animal instanceof Carnivoros){
            ((Carnivoros) animal).comerCarne();
        }else if(animal instanceof Herbivoro){
            ((Herbivoro) animal).comerHierba();
        }
    }
}
