package org.example;

public class AlimentarAnimal {
    public void comerAnimal(Animal animal) {
        if (animal instanceof ICarnivoro) {
            ((ICarnivoro) animal).comerCarne();
        }else if (animal instanceof IHerviboro) {
            ((IHerviboro) animal).comerHierba();
        } else {
            System.out.println("Este animal no come hierba o carne");
        }
    }
}
