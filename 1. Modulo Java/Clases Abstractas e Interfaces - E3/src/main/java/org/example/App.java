package org.example;

public class App 
{
    public static void main( String[] args )
    {
        Gato gato = new Gato();
        gato.emitirSonido();
        System.out.println(gato.comer());

        Perro perro = new Perro();
        perro.emitirSonido();
        System.out.println(perro.comer());

        Vaca vaca = new Vaca();
        vaca.emitirSonido();
        System.out.println(vaca.comer());

        System.out.println(comerAnimal(vaca));
    }

    public static String comerAnimal(Animal animal) {
        if (animal instanceof Gato) {
            return ((Gato) animal).comer();
        } else if (animal instanceof Perro) {
            return ((Perro) animal).comer();
        } else if (animal instanceof Vaca) {
            return ((Vaca) animal).comer();
        }
        return "";
    }
}
