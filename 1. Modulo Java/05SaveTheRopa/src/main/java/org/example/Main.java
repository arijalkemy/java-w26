package org.example;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Prenda borcegos = new Zapatilla("Hush Puppies", "No se");
        Prenda zapatillas = new Zapatilla("Adidas", "Forum Low");
        List<Prenda> listaPrendas = new ArrayList<>();
        listaPrendas.add(borcegos);
        listaPrendas.add(zapatillas);

        GuardaRopa guardaRopa = new GuardaRopa();
        Integer id = guardaRopa.guardarPrendas(listaPrendas);

        guardaRopa.mostrarPrendas();
    }
}

