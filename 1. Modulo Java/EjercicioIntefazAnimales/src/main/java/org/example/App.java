package org.example;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Perro perro = new Perro("pepe","Guau");
        Gato gato = new Gato("mantequilla","Miau");
        Vaca vaca= new Vaca("lolita","Muuuu");

        perro.hacerSonido();
        perro.comerCarne();
        perro.comerHierva();

        gato.hacerSonido();
        gato.comerCarne();
        gato.comerHierva();

        vaca.hacerSonido();
        vaca.comerCarne();
        vaca.comerHierva();


    }
}
