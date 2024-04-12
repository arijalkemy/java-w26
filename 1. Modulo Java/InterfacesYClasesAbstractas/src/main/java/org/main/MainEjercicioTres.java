package org.main;

import org.ejerciciotres.entities.Animal;
import org.ejerciciotres.entities.Gato;
import org.ejerciciotres.entities.Perro;
import org.ejerciciotres.entities.Vaca;
import org.ejerciciotres.interfaces.IAniamlHervivoro;
import org.ejerciciotres.interfaces.IAnimalCarnivoro;

public class MainEjercicioTres {
    public static void main(String[] args) {
        Vaca vaca = new Vaca();
        vaca.emitirSonido();
        vaca.comerHervivoro();
        Perro perro = new Perro();
        perro.emitirSonido();
        perro.comerCarnivoro();
        Gato gato = new Gato();
        gato.emitirSonido();
        gato.comerCarnivoro();

        comerAnimal(gato);
        comerAnimal(perro);
        comerAnimal(vaca);
    }

    public static void comerAnimal(Animal animal){
        if(animal instanceof IAnimalCarnivoro){
            ((IAnimalCarnivoro) animal).comerCarnivoro();
        }
        if (animal instanceof IAniamlHervivoro){
            ((IAniamlHervivoro) animal).comerHervivoro();
        }
    }
}
