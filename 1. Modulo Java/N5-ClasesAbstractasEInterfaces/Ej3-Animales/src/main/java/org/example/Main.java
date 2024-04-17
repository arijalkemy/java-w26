package org.example;

import org.example.model.*;
import org.example.model.Animal;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
// Creación de diferentes animales
        Animal perro = new Perro();
        Animal gato = new Gato();
        Animal vaca = new Vaca();

        // Invocación de métodos
        ((Perro) perro).emitirSonido();
        comerAnimal(perro);

        ((Gato) gato).emitirSonido();
        comerAnimal(gato);

        ((Vaca) vaca).emitirSonido();
        comerAnimal(vaca);

        comerAnimal(perro);

    }

    // Método para comerAnimal
    public static void comerAnimal(Animal animal) {
        if (animal instanceof ICarnivoro) {
            ((ICarnivoro) animal).comerCarne();
        } else if (animal instanceof IHerviboro) {
            ((IHerviboro) animal).comerHierba();
        } else {
            System.out.println("Este animal no puede comer");
        }
    }
}