package org.example;

import java.util.Arrays;
import java.util.List;

public class App
{
    public static void main( String[] args )
    {
        Prenda prenda1 = new Prenda("ssss", "ssss");
        Prenda prenda2 = new Prenda("aaaaa", "aaaaa");
        List<Prenda> listaDePrenda = Arrays.asList(prenda1, prenda2);

        GuardaRopa guardaRopa = new GuardaRopa();

        System.out.println( "Prendas agregadas en Ropero " + guardaRopa.guardarPrendas(listaDePrenda) );

        guardaRopa.mostrarPrendas();
    }
}
