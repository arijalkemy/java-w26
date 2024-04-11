package ejercicio3;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {
        Perro perro = new Perro();
        Gato gato = new Gato();
        Vaca vaca = new Vaca();

        Comida.comerAnimal(perro);
        Comida.comerAnimal(gato);
        Comida.comerAnimal(vaca);
    }
}
