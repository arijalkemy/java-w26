package bootcamp.bendezujonathan;

import bootcamp.bendezujonathan.animals.Animal;
import bootcamp.bendezujonathan.animals.implementations.Gato;
import bootcamp.bendezujonathan.animals.implementations.Perro;
import bootcamp.bendezujonathan.animals.implementations.Vaca;
import bootcamp.bendezujonathan.animals.interfaces.Carnivoro;
import bootcamp.bendezujonathan.animals.interfaces.Herviboro;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Gato naranjoso = new Gato();
        feedAnimal(naranjoso);  

        Perro fatiga = new Perro();
        feedAnimal(fatiga);

        Vaca lola = new Vaca();
        feedAnimal(lola);

    }


    public static void feedAnimal(Animal animalito) {
        animalito.emitirSonido();
        if(animalito instanceof Herviboro) ((Herviboro) animalito).comerHierba();

        if(animalito instanceof Carnivoro)  ((Carnivoro) animalito).comerCarne();
        
    }
}
