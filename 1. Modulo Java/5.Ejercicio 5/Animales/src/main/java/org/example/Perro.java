package org.example;

public class Perro extends Animal implements ICarnivoro{
    private double peso;


    public Perro(double peso,String nombre, String raza) {
        super(nombre, raza);
        this.peso = peso;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public void emitirSonido() {
        System.out.println("Guau");
    }

    public void comerAnimal() {
        comerCarne();
    }

    public void comerCarne() {
        System.out.println("Soy un perro comiendo carne");
    }
}
