package org.bootcamp;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Hello world!
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("SAVE THE ROPA!");

        GuardaRopa guardaRopa = new GuardaRopa();

        List<Prenda> prendas = new ArrayList<>();
        prendas.add(
                new Prenda("Gucci", "Cmisa básica")
        );
        prendas.add(
                new Prenda("Adidas", "Zapatos"));


        System.out.println(guardaRopa.guardarPrendas(prendas));
        guardaRopa.mostrarPrendas();

        guardaRopa.mostrarPrendas();

        List<Prenda> prendasPorNumero = guardaRopa.devolverPrendas(0);
        prendasPorNumero.forEach(x -> System.out.println(x));
    }
}
