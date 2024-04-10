package org.example;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {

       Animal perro = new Perro("Perro","Dogui");
       perro.mostrarEspecie();
       perro.hacerSonido();

       Gato gato = new Gato("Gato","Rufu");
       gato.mostrarEspecie();
       gato .hacerSonido();

       Animal animal = new Animal("Clase padre animal");
       animal.mostrarEspecie();
       animal.hacerSonido();


    }
}
