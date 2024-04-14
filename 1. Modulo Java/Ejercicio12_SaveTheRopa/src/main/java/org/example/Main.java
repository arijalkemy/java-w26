package org.example;

import java.util.ArrayList;
import java.util.List;

;

public class Main {
    public static void main(String[] args) {
        GuardaRopa guardaRopa = new GuardaRopa();
        List<Prenda> prendas = new ArrayList<>();
        prendas.add(new Prenda("Adidas", "23441"));
        prendas.add(new Prenda("Nike", "alsdkfj234"));
        prendas.add(new Prenda("Puma", "XJQ123"));
        Integer codigo = guardaRopa.guardarPrendas(prendas);
        System.out.println("Codigo obtenido: " + codigo);
        System.out.println("Prendas guardadas: ");
        guardaRopa.mostrarPrendas();
        System.out.println("Prendas obtenidas tras retirar: ");
        for (Prenda prenda : guardaRopa.devolverPrendas(codigo)) {
            System.out.println("\t" + prenda.toString());
        }
        System.out.println("Prendas guardadas: ");
        guardaRopa.mostrarPrendas();
    }
}