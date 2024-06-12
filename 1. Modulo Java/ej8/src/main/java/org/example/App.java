package org.example;

import org.example.Animales.*;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
         Animal vaca = new Vaca();
         Animal perro = new Perro();

         comerAnimal(vaca);
         comerAnimal(perro);
    }

    //comer animal verifica la instancia y ejecuta de acuerdo a la clase
    public static void comerAnimal(Animal animal){
        if (animal instanceof Carnivoro){
            ((Carnivoro) animal).comerCarne();
        }else {
            ((Herbivoro)animal).comerHierba();
        }
    }
}
