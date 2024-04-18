package org.example;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        Perro p = new Perro(20, "paco", "golden");
        Vaca c = new Vaca("Bartola", "milka", true);
        Gato g = new Gato("Marron", "Michi", "Siames");

        p.emitirSonido();
        p.comerCarne();

        c.emitirSonido();
        c.comerHierva();

        g.emitirSonido();
        g.comerCarne();

        comerAnimal(p);
        comerAnimal(c);
        comerAnimal(g);


    }
    public static void comerAnimal(Animal a ){
        a.comerAnimal();
    }
}
