package ClasesAbstractasInterfaces.Animales;

import ClasesAbstractasInterfaces.Animales.animales.Animal;
import ClasesAbstractasInterfaces.Animales.animales.Gato;
import ClasesAbstractasInterfaces.Animales.animales.Perro;
import ClasesAbstractasInterfaces.Animales.animales.Vaca;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Animal> animals = new ArrayList<Animal>(){{
            add(new Vaca());
            add(new Gato());
            add(new Perro());
        }};
        
        for (Animal animal : animals) {
            Animal.comerAnimal(animal);
            animal.emitirSonido();
        }

    }
}
