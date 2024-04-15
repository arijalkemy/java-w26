package meli.bootcamp.SaveTheRopa;

import meli.bootcamp.SaveTheRopa.entidades.GuardaRopa;
import meli.bootcamp.SaveTheRopa.entidades.Prenda;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<Prenda> prendas = List.of(new Prenda("Remera", "Lacoste"),
                new Prenda("Buzo", "Element"));
        List<Prenda> prendas2 = List.of(new Prenda("Jean", "Levis"),
                new Prenda("Campera", "Puma"));

        GuardaRopa guardaRopa = new GuardaRopa();


        System.out.println(guardaRopa.guardarPrendas(prendas));
        guardaRopa.guardarPrendas(prendas2);

        guardaRopa.mostrarPrendas();

        System.out.println(guardaRopa.devolverPrendas(1));
    }


}
