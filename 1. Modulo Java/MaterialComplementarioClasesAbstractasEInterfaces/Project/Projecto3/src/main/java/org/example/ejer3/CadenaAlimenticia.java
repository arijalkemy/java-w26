package org.example.ejer3;

public class CadenaAlimenticia {
    public static void comerAnimal(Animal animal){
        if(animal instanceof ICarnivoro){
            System.out.println(((ICarnivoro) animal).comerCarne());
        } else if(animal instanceof IHerbivoro){
            System.out.println(((IHerbivoro) animal).comerHierba());
        } else{
            System.out.println("No se puede determinar el tipo de alimentación del animal");
        }
    }
}
