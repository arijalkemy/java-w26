package org.main;

import org.entities.GuardaRopa;
import org.entities.Prenda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class App 
{
    public static void main( String[] args )
    {
        Prenda prendaUno = new Prenda("Adidas","Jacket");
        Prenda prendaDos = new Prenda("Adidas","Bamba");
        Prenda prendaTres = new Prenda("Adidas","Toallin");

        List<Prenda> prendas = Arrays.asList(prendaUno, prendaDos, prendaTres);

        GuardaRopa guardaRopa = new GuardaRopa();
        guardaRopa.guardarPrendas(prendas);

        guardaRopa.mostrarPrendas();

        List<Prenda> prendas2 = guardaRopa.devolverPrendas(1);
        System.out.println("Prendas desde main\n");
        prendas2.forEach(System.out::println);
    }
}
