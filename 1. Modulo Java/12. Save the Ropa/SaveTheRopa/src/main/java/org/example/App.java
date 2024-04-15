package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
       Prenda prenda1 = new Prenda("Coach", "109");
       Prenda prenda2 = new Prenda("Pull", "209");

       List<Prenda> prendaList1 = new ArrayList<>();
       prendaList1.add(prenda1);
       prendaList1.add(prenda2);

       GuardaRopa guardaRopa = new GuardaRopa();

       Integer value = guardaRopa.guardarPrendas(prendaList1);
        System.out.println(value);
        guardaRopa.mostrarPrendas();

        List<Prenda> myPrendas = guardaRopa.devolverPrenda(value);
        System.out.println(myPrendas);
    }
}
