package com.meli;

/**
 * Hello world!
 *
 */
public class App
{
    public static void main( String[] args )
    {
        Animal perro = new Perro();
        Animal gato = new Gato();
        Animal vaca = new Vaca();

        // Invocación de sus respectivas implementaciones de métodos
        perro.emitirSonido();
        perro.comerCarne();

        gato.emitirSonido();
        gato.comerCarne();

        vaca.emitirSonido();
        vaca.comerHierba();

        // Llamada al método comerAnimal con un objeto de tipo Animal
        comerAnimal(perro);
        comerAnimal(gato);
        comerAnimal(vaca);
    }

    public static void comerAnimal(Animal animal) {
        if (animal instanceof Perro) {
            animal.comerCarne();
        } else if (animal instanceof Gato) {
            animal.comerCarne();
        } else if (animal instanceof Vaca) {
            animal.comerHierba();
        }
    }
}
