package org.example;

import org.example.animal.Animal;
import org.example.animal.Gato;
import org.example.animal.Perro;
import org.example.animal.Vaca;

public class App 
{
    public static void main( String[] args )
    {
        Perro perro = new Perro();
        Gato gato = new Gato();
        Vaca vaca = new Vaca();

        perro.emitirSonido();
        gato.emitirSonido();
        vaca.emitirSonido();

        comerAnimal(gato);
        comerAnimal(perro);
        comerAnimal(vaca);
    }
        public static void comerAnimal(Animal animal) {
        if (animal instanceof Gato) {
            ((Gato) animal).comerCarne();
        } else if (animal instanceof Perro) {
            ((Perro) animal).comerCarne();
        } else if (animal instanceof Vaca) {
            ((Vaca) animal).comerHierba();
        }
    }

}
