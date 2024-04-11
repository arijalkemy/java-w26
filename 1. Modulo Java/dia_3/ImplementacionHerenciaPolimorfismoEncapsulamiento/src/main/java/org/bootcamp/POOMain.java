package org.bootcamp;

/**
 * Hello world!
 */
public class POOMain {
    public static void main(String[] args) {
        Animal perro = new Perro("Perro", "kira");
        perro.mostrarEspecie();
        perro.hacerSonido();

        Gato gato = new Gato("gato", "Moli");
        gato.mostrarEspecie();
        gato.hacerSonido();

        Animal animal = perro;
        animal.mostrarEspecie();
        animal.hacerSonido();
        System.out.println("Hello World!");
    }
}
