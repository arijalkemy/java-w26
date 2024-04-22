package org.saveTheRopa;

import java.util.List;

public class MainExample {

    public static void main(String[] args) {
        Prenda unaPrenda = new Prenda("Guccci", "Gorra noche");
        Prenda otraPrenda = new Prenda("Adidas", "Campera");

        GuardaRopa unGuardaropa = new GuardaRopa();
        int codigo = unGuardaropa.guardarPrendas(List.of(unaPrenda, otraPrenda));

        System.out.println(unGuardaropa.devolverPrendas(codigo));

        unGuardaropa.mostrarPrendas();
    }
}
