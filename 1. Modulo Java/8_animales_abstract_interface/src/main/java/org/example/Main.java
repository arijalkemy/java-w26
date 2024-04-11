package org.example;

import org.example.classes.Animal;
import org.example.classes.Gato;
import org.example.classes.Perro;
import org.example.classes.Vaca;
import org.example.interfaces.Carnivoro;

public class Main {
    public static void main(String[] args) {

        Vaca vaca = new Vaca();
        vaca.emitirSonido();
        vaca.comerHierba();
        System.out.println();

        Perro perro = new Perro();
        perro.emitirSonido();
        perro.comerCarne();
        System.out.println();

        Gato gato = new Gato();
        gato.emitirSonido();
        gato.comerCarne();
        System.out.println();

        comerAnimal(vaca);
        comerAnimal(perro);
        comerAnimal(gato);
    }

    public static void comerAnimal(Animal animal){
        if(animal instanceof Perro || animal instanceof Gato){
            ((Carnivoro) animal).comerCarne();
            // En base al contexto se da cuenta
            return;
        }
        if(animal instanceof Vaca){
            ((Vaca) animal).comerHierba();
        }
    }
}