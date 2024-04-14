package org.example;

import org.example.Clases.GuardaRopa;
import org.example.Clases.Prenda;

import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {
        Prenda camisa = new Prenda("Tommy", "camisa");
        Prenda mate = new Prenda("Stanley", "mate");
        Prenda pantalon = new Prenda("Tommy", "pantalon");

        GuardaRopa guardaRopa = new GuardaRopa();
        List<Prenda> listaPrenda1 = new ArrayList<>();
        listaPrenda1.add(camisa);
        listaPrenda1.add(mate);

        List<Prenda> listaPrenda2 = new ArrayList<>();

        listaPrenda2.add(pantalon);

        guardaRopa.guardarPrendas(listaPrenda1);
        guardaRopa.guardarPrendas(listaPrenda2);

        guardaRopa.mostrarPendas();


        System.out.println("SACANDO GUARDARROPA CODIGO 1...");
        List<Prenda> prendaDevuelto = guardaRopa.devolverPrendas(1);


        System.out.println();
        System.out.println("PRENDA DEVUELTA: ");
        System.out.print(prendaDevuelto);

        System.out.println();
        System.out.println();
        System.out.println("PRENDAS GUARDADAS: ");
        guardaRopa.mostrarPendas();

    }
}
