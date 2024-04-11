package ej3;

public interface TipoDeAlimentacionDeAnimal {
    static void comerAnimal(Animal animal){
        if(animal instanceof Carnivoro){
            ((Carnivoro) animal).comerCarne();
        } else if(animal instanceof Herviboro){
            ((Herviboro) animal).comerPlanta();
        }
    }
}
