package org.main;

import org.ejerciciotres.entities.Animal;
import org.ejerciciotres.entities.Vaca;
import org.ejerciciotres.interfaces.IAniamlHervivoro;

public class MainEjercicioTres {
    public static void main(String[] args) {
        Animal<IAniamlHervivoro> vaca = new Vaca();
        vaca.comerAnimal(new Vaca());
    }
}
