package Especificacion;

import Clases.Animal;
import Clases.Gato;
import Clases.Perro;
import Clases.Vaca;
import Interfaces.ICarnivoro;
import Interfaces.IHerviboro;

public class main {
    public static void comerAnimal(Animal animal) {
        if(animal instanceof ICarnivoro){
            ((ICarnivoro) animal).comerCarne();
        }

        if(animal instanceof IHerviboro){
            ((IHerviboro) animal).comerHierba();
        }
    }

    public static void main(String[] args) {
        Animal gato = new Gato();
        Animal vaca = new Vaca();
        Animal perro = new Perro();

        gato.emitirSonido();
        comerAnimal(gato);

        vaca.emitirSonido();
        comerAnimal(vaca);

        perro.emitirSonido();
        comerAnimal(perro);
    }



}
