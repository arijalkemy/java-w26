package org.main.ejercicio3.clases;
import org.main.ejercicio3.interfaces.Herbivoro;

public class Vaca extends Animal implements Herbivoro {

    public Vaca() {
        this.tipo = "Herbivoro";
    }

    @Override
    public void hacersonido() {
        System.out.println("Muuuuuu");
    }

    @Override
    public void comerHierba() {
        System.out.println("La vaca come hierba");
    }
}
