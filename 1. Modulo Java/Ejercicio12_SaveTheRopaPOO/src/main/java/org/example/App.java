package org.example;

import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        int idPrenda1=0;
        int idPrenda2=0;
        int idPrenda3=0;
        Prenda p1 = new Camisa("AC","Ejecutivo","L",80000);
        Prenda p2 = new Camisa("Polo","Polo","M",160000);
        Prenda p3 = new Camisa("AC","Sport","XL",100000);
        Prenda p4 = new Camisa("Polo","Ejecutivo","XXL",220000);
        Prenda p5 = new Pantalon("AC","Ejecutivo",34,90000);
        Prenda p6 = new Pantalon("Levis","Jean",36,140000);
        Prenda p7 = new Pantalon( "AC","Dril",36,100000);
        Prenda p8 = new Pantalon("Jeans","Jean",35, 160000);
        Prenda p9 = new Zapatos("Adidas","Addi2000",42,890000);
        Prenda p10 = new Zapatos("Nike","Mercurial",40, 650000);

        List<Prenda> prendas1 = new ArrayList<>();
        List<Prenda> prendas2 = new ArrayList<>();
        List<Prenda> prendas3 = new ArrayList<>();

        prendas1.add(p1);
        prendas1.add(p3);
        prendas1.add(p10);
        prendas1.add(p8);
        prendas1.add(p4);
        prendas2.add(p2);
        prendas2.add(p4);
        prendas2.add(p5);
        prendas2.add(p9);
        prendas2.add(p1);
        prendas3.add(p1);
        prendas3.add(p6);
        prendas3.add(p7);
        prendas3.add(p10);
        prendas3.add(p2);

        GuardaRopa guardaRopa = new GuardaRopa();
        idPrenda1 = guardaRopa.guardarPrendas(prendas1);
        idPrenda2 = guardaRopa.guardarPrendas(prendas2);
        idPrenda3 = guardaRopa.guardarPrendas(prendas3);

        guardaRopa.mostrarPrendas();

        guardaRopa.devolverPrendas(idPrenda3).stream().forEach(System.out::println);
    }
}
