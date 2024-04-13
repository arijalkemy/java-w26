package org.example;


public class App 
{
    public static void main( String[] args )
    {
        Perro perro = new Perro();
        Gato gato = new Gato();
        Vaca vaca = new Vaca();

        App app = new App();
        System.out.println("Perro");
        perro.emitirSonido();
        app.comerAnimal(perro);

        System.out.println("Gato");
        gato.emitirSonido();
        app.comerAnimal(gato);

        System.out.println("Vaca");
        vaca.emitirSonido();
        app.comerAnimal(vaca);


    }

    public void comerAnimal(Animal animal) {
        animal.comer();
    }
}
