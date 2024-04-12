package org.example;

import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        GuardaRopa guardaRopa = new GuardaRopa();
        Prenda prenda = new Prenda("Nike", "Remera");
        Prenda prenda2 = new Prenda("Adidas", "Pantalón");
        guardaRopa.guardarRopa(Stream.of(prenda).collect(Collectors.toList()));
        guardaRopa.guardarRopa(Stream.of(prenda2).collect(Collectors.toList()));
        guardaRopa.mostrarPrendas();
        System.out.println(guardaRopa.devolverPrenda(0));
        guardaRopa.mostrarPrendas();
    }
}
