package org.example.ejercicio3;

public class Main {
    public static void main( String[] args ) {
        Perro perro = new Perro();
        Gato gato = new Gato();
        Vaca vaca = new Vaca();

        perro.emitirSonido();
        gato.emitirSonido();
        vaca.emitirSonido();

        System.out.println("Metodo de comer Animal");
        System.out.println(comerAnimal(perro));
        System.out.println(comerAnimal(gato));
        System.out.println(comerAnimal(vaca));

    }
    public static String comerAnimal(Animal animal) {
       if (animal instanceof Vaca) {
           return ((Vaca) animal).comeHierba();
       }
       if (animal instanceof Perro) {
               return ((Perro) animal).comeCarne();
       }
       return ((Gato) animal).comeCarne();
    }

}
