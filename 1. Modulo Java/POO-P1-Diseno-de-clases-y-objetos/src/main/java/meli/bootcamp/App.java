package meli.bootcamp;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Automovil ferrari = new Automovil("Ferrari", "rojo", 10000);

        System.out.println(ferrari.mostrarMarcaYColor());
    }
}
