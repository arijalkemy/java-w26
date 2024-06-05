package org.example;

import logica.*;

/**
 * Ejercicio practico alimentacion de animales
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Programa alimentacionde animales carnivoro y herviboro" );
        System.out.println( "______________________________________________________" );
        System.out.println( "Animal: gato" );
        Animal gato = new Gato();
        gato.emitirSonido();
        comerAnimal(gato);
        System.out.println( "______________________________________________________" );
        System.out.println( "Animal: Perro" );
        Animal perro = new Perro();
        perro.emitirSonido();
        comerAnimal(perro);
        System.out.println( "______________________________________________________" );
        System.out.println( "Animal: Vaca" );
        Animal vaca = new Vaca();
        vaca.emitirSonido();
        comerAnimal(vaca);
        System.out.println( "______________________________________________________" );
    }

    public static void comerAnimal(Animal animal){
        if( animal instanceof Gato ){
            System.out.println(((Gato) animal).comerCarne());
        }else if( animal instanceof Perro){
            System.out.println(((Perro) animal).comerCarne());
        }else if( animal instanceof Vaca){
            System.out.println(((Vaca) animal).comerHierba());
        }

    }

}
