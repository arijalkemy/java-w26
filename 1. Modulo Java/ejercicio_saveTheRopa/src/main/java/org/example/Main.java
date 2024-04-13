package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Hello world!
 *
 */
public class Main
{
    public static void main( String[] args ){
        /*
        * Guardamos dos prenda
         */
        Prenda prenda1 = new Prenda("Pato","Feo");
        Prenda prenda2 = new Prenda("Cuidado con el perro", "Amarilla");
        GuardaRopa guardaRopa = new GuardaRopa();
        guardaRopa.guardarPrendas(new ArrayList<>(Arrays.asList(prenda1, prenda2)));

        /*
        * Consultamos por las prendas
         */
        guardaRopa.mostrarPrendas();
    }
}
