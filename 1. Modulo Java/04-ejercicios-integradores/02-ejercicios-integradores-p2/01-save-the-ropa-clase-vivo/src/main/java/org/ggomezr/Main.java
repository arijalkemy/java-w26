package org.ggomezr;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        GuardaRopa guardaRopa = new GuardaRopa();

        Prenda prenda1 = new Prenda("Nike", "Zapatos deportivos");
        Prenda prenda2 = new Prenda("Adidas", "Camiseta");

        int codigo1 = guardaRopa.guardarPrendas(Arrays.asList(prenda1));
        int codigo2 = guardaRopa.guardarPrendas(Arrays.asList(prenda2));

        System.out.println("Se han guardado las prendas");
        System.out.println("Codigo prenda 1: " + codigo1);
        System.out.println("Codigo prenda 2: " + codigo2);

        System.out.println("\nConsultar prendas guardadas:");
        System.out.println("Prendas guardadas bajo el código " + codigo1 + ":");
        List<Prenda> prendasGuardadas1 = guardaRopa.devolverPrendas(codigo1);
        if (prendasGuardadas1 != null) {
            for (Prenda prenda : prendasGuardadas1) {
                System.out.println("Marca: " + prenda.getMarca() + ", Modelo: " + prenda.getModelo());
            }
        } else {
            System.out.println("No se encontraron prendas para el código " + codigo1);
        }

        System.out.println("---------------------------------");

        System.out.println("Prendas guardadas bajo el código " + codigo2 + ":");
        List<Prenda> prendasGuardadas2 = guardaRopa.devolverPrendas(codigo2);
        if (prendasGuardadas2 != null) {
            for (Prenda prenda : prendasGuardadas2) {
                System.out.println("Marca: " + prenda.getMarca() + ", Modelo: " + prenda.getModelo());
            }
        } else {
            System.out.println("No se encontraron prendas para el código " + codigo2);
        }
    }
}