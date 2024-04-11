package org.ggomezr;

public class Main {
    public static void comerAnimal(Animal animal){
        if(animal instanceof Carnivoro){
            ((Carnivoro) animal).comerCarne();
        }else if(animal instanceof Herbivoro){
            ((Herbivoro) animal).comerHierba();
        }
    }

    public static void main(String[] args) {
        System.out.println("\n----- Perro -----\n");
        Perro perro = new Perro();
        perro.emitirSonido();
        perro.comerCarne();
        comerAnimal(perro);

        System.out.println("\n----- Gato -----\n");
        Gato gato = new Gato();
        gato.emitirSonido();
        gato.comerCarne();
        comerAnimal(gato);

        System.out.println("\n----- Vaca -----\n");
        Vaca vaca = new Vaca();
        vaca.emitirSonido();
        vaca.comerHierba();
        comerAnimal(vaca);
    }
}