package org.bootcamp;

import org.bootcamp.domain.*;

/**
 * @author jsanchezpimi 
 */
public class App 
{
    public static void main(String[] args) {
        // Se instancian los objetos de animales
        Gato gato = new Gato();
        Perro perro = new Perro();
        Vaca vaca = new Vaca();

        // Se emiten los sonidos de los Animales
        gato.emitirSonido();
        perro.emitirSonido();
        vaca.emitirSonido();

        // Se emite los metodos de comer de los animales
        gato.comerCarne();
        perro.comerCarne();
        vaca.comerHierba();

        // Se instancia el metodo de comer animal generico
        comerAnimal(gato);
        comerAnimal(vaca);

    }

    /**
     * Metodo que recibe un valor animal generico valida la instancia del
     * tipo de animal segun la alimentacion e imprime su metodo de comer
     * @param animal
     * @param <T> de tipo de dato generico
     */
    private static <T> void comerAnimal(T animal){
        if(animal instanceof IHerviboro){
            ((IHerviboro) animal).comerHierba();
        }

        if(animal instanceof ICarnivoro){
            ((ICarnivoro) animal).comerCarne();
        }
    }
}
