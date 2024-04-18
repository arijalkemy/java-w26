package org.example;

public class Gato extends Animal implements ICarnivoro {

    private String color;


    public Gato(String color, String nombre, String raza) {
        super(nombre, raza);
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void emitirSonido() {
        System.out.println("Miau");
    }

    public void comerAnimal() {
        comerCarne();
    }

    public void comerCarne() {
        System.out.println("Soy un Gato comiendo carne");
    }

}
