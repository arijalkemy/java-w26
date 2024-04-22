package org.example;

import org.example.entity.Prenda;
import org.example.repository.GuardaRopa;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        GuardaRopa guardaRopa = new GuardaRopa();
        Prenda buzo = new Prenda("Tascani", "atlantic");
        Prenda botines = new Prenda("Adidas", "Adizero");

        Integer id1 = guardaRopa.guardarPrendas(List.of(buzo, botines));
        System.out.println("Id del primer guardado de ropa: " + id1);

        System.out.println("Todas las prendas:");
        guardaRopa.mostrarPrendas();

        System.out.println();
        System.out.println("Prendas del id 0");
        System.out.println(guardaRopa.devolverPrendas(0));

    }
}