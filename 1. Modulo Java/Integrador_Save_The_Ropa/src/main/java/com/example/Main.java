package com.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {

        // * Se guardan las dos prendas en una lista
        Prenda p1 = new Prenda("Gucci", "Pantalon");
        Prenda p2 = new Prenda("Vans", "Zapatillas");

        List<Prenda> prendas = new ArrayList<>();
        prendas.add(p1);
        prendas.add(p2);

        GuardaRopa guardaRopa = new GuardaRopa();
        int codigo = guardaRopa.guardarPrendas(prendas);
        Optional<List<Prenda>> misPrendas = guardaRopa.devolverPrendas(codigo);

        if (misPrendas.isPresent()) {
            System.out.println(misPrendas.get());
        } else {
            System.out.println("No existe el codigo de prendas proporcionado.");
        }

    }
}