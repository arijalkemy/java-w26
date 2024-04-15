package org.example.savetheropa;


import java.util.List;

/**
 * Hello world!
 *
 */
public class Main
{
    public static void main( String[] args )
    {
        GuardaRopa guardaRopa = new GuardaRopa();

        int codigoGuardaropa = guardaRopa.guardarPrendas(List.of(
            new Prenda("Versace", "Camperón deluxe"),
            new Prenda("Prada", "Sombrero tontín")
        ));

        System.out.println("Prendas que están en el guardaropa antes del retiro:");
        guardaRopa.mostrarPrendas();

        List<Prenda> prendasDevueltas = guardaRopa.devolverPrendas(codigoGuardaropa);

        System.out.println("\nPrendas devueltas por el guardaropa:");
        prendasDevueltas.forEach(System.out::println);

        System.out.println("\nPrendas que están en el guardaropa después del retiro:");
        guardaRopa.mostrarPrendas();
    }
}
