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
        Pantalon pantalon = new Pantalon("Adidas", "Sudadera");
        Saco saco = new Saco("Nike", "Formal");

        List<Prenda> prendasGuardar = new ArrayList<>();

        prendasGuardar.add(pantalon);
        prendasGuardar.add(saco);

        GuardaRopa locker = new GuardaRopa();
        Integer identificador = locker.guardarPrendas(prendasGuardar);
        System.out.println("Prendas guardadas con identificador: " + identificador + "\n");

        locker.mostrarPrendas();

        System.out.println("\nRegresando Prendas");
        System.out.println(locker.devolverPrendas(2));
    }
}
