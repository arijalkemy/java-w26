package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public class Main {
    public static void main(String[] args) {
        GuardarRopa gr = new GuardarRopa();
        UUID id = gr.guardarPrendas(new ArrayList<>(
                Arrays.asList(
                        new Prenda("Nike", "Deportivo"),
                        new Prenda("Puma", "Formal"),
                        new Prenda("Puma", "Deportivo")
                )
        ));
        List<Prenda> prendas = gr.devolverPrendas(UUID.randomUUID());
        gr.mostrarPrendas();


    }
}