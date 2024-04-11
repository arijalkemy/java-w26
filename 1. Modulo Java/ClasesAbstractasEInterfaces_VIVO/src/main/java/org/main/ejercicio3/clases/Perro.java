package org.main.ejercicio3.clases;
import org.main.ejercicio3.interfaces.Carnivoro;

public class Perro extends Animal implements Carnivoro{

    public Perro() {
        this.tipo = "Carnivoro";
    }
    @Override
    public void hacersonido() {
        System.out.println("Guau guau");
    }

    @Override
    public void comerCarne() {
        System.out.println("El perro come carne");
    }
}
