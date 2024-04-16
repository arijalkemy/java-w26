package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        List<Prenda> prendasList = new ArrayList<>();
//      Guardar dos prendas de topa den mi lista
        prendasList.add(new Prenda("ejemplo", "2024"));
        prendasList.add(new Prenda("ejemplo", "2022"));

//        Instanciar mi clase GuardaRopa
        GuardaRopa guardaRopa = new GuardaRopa();

//        Guardar la lista de prendas en el guardaropa
        guardaRopa.guardarPrendas(prendasList);

//        Mostrar los elementos que hay dento delk guardaropa
        guardaRopa.mostrarPrendas();

//        Mostrar prendas por indice
        System.out.println("---------Mostrando las prendas con el indice 1---------");
        guardaRopa.mostrarPrendasByIndex(1);


    }
}
