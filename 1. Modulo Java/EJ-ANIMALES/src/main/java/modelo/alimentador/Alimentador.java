package modelo.alimentador;

import enums.GustosAlimenticios;
import interfaces.ICarnivoro;
import interfaces.IHerviboro;
import modelo.animales.Animal;

public class Alimentador {
    public static void alimentarAnimal(Animal animal){
        if(animal.getGustosAlimenticio() ==  GustosAlimenticios.CARNIVORO){
            ((ICarnivoro) animal).comerCarne();
        } else {
            ((IHerviboro) animal).comerHierba();
        }
    }
}
