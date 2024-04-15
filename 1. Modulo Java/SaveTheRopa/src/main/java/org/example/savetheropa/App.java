package org.example.savetheropa;

import org.example.savetheropa.modelo.GuardaRopa;
import org.example.savetheropa.modelo.Prenda;

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
        int codigo = guardaRopa.guardarPrendas(List.of(
                new Prenda("Nike", "Zapatilla"),
                new Prenda("Addidas", "Campera")
        ));
        guardaRopa.devolverPrendas(codigo).forEach(System.out::println);
    }
}
