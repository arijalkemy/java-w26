package org.example;

import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        /*
        * Crear el método public Integer guardarPrendas(List<Prenda> listaDePrenda), en la Clase GuardaRopa, que recibe una lista de prendas y devuelve el número identificador en donde quedaron asignadas las prendas, es decir la clave del diccionario en donde guardamos las mismas.
          Crear el método public void mostrarPrendas() en la Clase GuardaRopa que imprime por pantalla todas las prendas que quedan en el guardarropas junto con el número que les corresponde.
          Crear el método public List<Prenda> devolverPrendas(Integer numero), en la Clase GuardaRopa que devuelve la lista de prendas que están guardadas bajo ese número.
          Crear en la clase Main un escenario en el cual alguien guarde dos prendas, reciba el código y luego consulta por sus prendas guardadas.
        * */

        Prenda prenda1 = new Prenda("Zara", "Jean");
        Prenda prenda2 = new Prenda("Prune", "Manga corta");

        List<Prenda> prendas = new ArrayList<>();
        prendas.add(prenda1);
        prendas.add(prenda2);

        GuardaRopa guardaRopa = new GuardaRopa();
        int codGuardado = guardaRopa.guardarPrendas(prendas);
        System.out.println("El codigo con el que se guardo su ropa es: " + codGuardado);

        System.out.println("Las prendas guardadas con el codigo anterior son: " + guardaRopa.devolverPrendas(codGuardado));

        System.out.println("Las prendas que tiene el guardaropa son: ");
        guardaRopa.mostrarPrendas();

    }
}
