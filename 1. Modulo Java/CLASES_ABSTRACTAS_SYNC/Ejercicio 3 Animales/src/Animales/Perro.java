package Animales;

import IAnimales.Carnivoro;

public class Perro extends Animal  implements Carnivoro{

    @Override
    public void emitirSonido() {
        System.out.println("Guao");
    }

    @Override
    public void comerCarne() {
        System.out.println("Comiendome un gatito :)");
    }

    @Override
    public void comer() {
        this.comerCarne();
    }
    
}
