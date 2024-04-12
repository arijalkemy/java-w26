package org.example.Ejercicios_Integradores_P1.SINC.SaveTheRopa;

import java.util.List;

public class App {

    public static void main(String[] args) {

        GuardaRopa guardaRopa = new GuardaRopa();
        guardaRopa.guardarPrendas(List.of(new Prenda("Nike", "AirMax"), new Prenda("Adidas", "SuperStar")));
        guardaRopa.guardarPrendas(List.of(new Prenda("Nike2", "AirMax2"), new Prenda("Adidas2", "SuperStar2")));


        guardaRopa.mostrarPrendas();
        System.out.println(guardaRopa.devolverPrendas(0));

    }
}
