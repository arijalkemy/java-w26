package org.bootcamp.ejercicio3;

public class Main {
    public static void main(String[] args) {
        Perro perro = new Perro();
        perro.hacerSonido();
        perro.comer();
        Main m = new Main();
        m.comerAnimal(perro);
    }
    public String comerAnimal(Animal animal){
        return "Comiste" + animal.toString();
    }
}
