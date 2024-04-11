package org.main.ejercicio3.clases;
import org.main.ejercicio3.interfaces.Carnivoro;

public class Gato extends Animal implements Carnivoro{

    public Gato() {
        this.tipo = "Carnivoro";
    }

    @Override
    public void hacersonido() {
        System.out.println("Miau miau");
    }

    @Override
    public void comerCarne() {
        System.out.println("El gato come carne");
    }
}
