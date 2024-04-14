package org.example;

import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 *
 */
public class Main
{
    public static void main( String[] args )
    {
        Prenda camisa = new Prenda("gucci", "A");
        Prenda pantalon = new Prenda("Nike", "B");
        GuardaRopa gr = new GuardaRopa();
        List<Prenda> prendas = new ArrayList<>();
        prendas.add(camisa);
        prendas.add(pantalon);
        int id =gr.guardarPrendas(prendas);

        for (Prenda prenda: gr.devolverPrendas(id)){
            System.out.println(prenda.getMarca());
        }
    }
}
