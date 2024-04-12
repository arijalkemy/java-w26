package org.example;

import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        GuardaRopa guardaRopa = new GuardaRopa();
        Prenda prenda1 = new Prenda("Adidas", "Gorra");
        Prenda prenda2 = new Prenda("TNF", "Campera negra");
        Prenda prenda3 = new Prenda("Nike", "Short running");

        Integer posicion = guardaRopa.guardarPrendas(List.of(prenda1, prenda2));
        guardaRopa.guardarPrendas(List.of(prenda3));

        System.out.println("Estado del guardarropas: ");
        guardaRopa.mostrarPrendas();

        System.out.println(
                "\nSolicitio las prendas en la posicion " + posicion +
                " y me devuelven: \n" + guardaRopa.devolverPrendas(posicion));

        System.out.println("\nEstado del guardarropas: ");
        guardaRopa.mostrarPrendas();
    }
}
