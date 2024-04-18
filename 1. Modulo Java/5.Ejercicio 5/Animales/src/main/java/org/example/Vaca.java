package org.example;

public class Vaca extends Animal implements IHervivoro{

    private boolean manchada;

    public Vaca(String nombre, String raza, boolean manchada) {
        super(nombre, raza);
        this.manchada = manchada;
    }

    public boolean isManchada() {
        return manchada;
    }

    public void setManchada(boolean manchada) {
        this.manchada = manchada;
    }

    public void emitirSonido() {
        System.out.println("Muuuu");
    }

    public void comerAnimal() {
        comerHierva();
    }

    public void comerHierva() {
        System.out.println("Soy una vaca comiendo hierva");
    }
}
