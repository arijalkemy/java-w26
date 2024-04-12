package org.example;

import org.example.clases.GuardaRopa;
import org.example.clases.Prenda;

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
        Prenda remera = new Prenda("Nike", "no tiene");
        Prenda buzo = new Prenda("Adidas", "Originals");
        Prenda zapatilla = new Prenda("Puma", "no se");

        List<Prenda> prendas = new ArrayList<>();
        prendas.add(remera);
        prendas.add(buzo);

        List<Prenda> prendas1 = new ArrayList<>();
        prendas1.add(remera);

        List<Prenda> prendas2 = new ArrayList<>();
        prendas2.add(zapatilla);

        GuardaRopa guardaRopa = new GuardaRopa();

        int id = guardaRopa.guardarPrendas(prendas);
        System.out.println("La prenda se guardo con exito, el id es: " + id);

        id = guardaRopa.guardarPrendas(prendas1);
        System.out.println("La prenda se guardo con exito, el id es: " + id);

        id = guardaRopa.guardarPrendas(prendas2);
        System.out.println("La prenda se guardo con exito, el id es: " + id);

        System.out.println("Sus prendas son: " + guardaRopa.devolverPrendas(id).toString());

    }
}
