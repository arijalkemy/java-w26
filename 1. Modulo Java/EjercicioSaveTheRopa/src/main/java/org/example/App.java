package org.example;

import java.util.ArrayList;
import java.util.List;

public class App
{
    public static void main( String[] args )
    {

        GuardaRopa g = new GuardaRopa();
        List <Prenda> prendas = new ArrayList<Prenda>();
        prendas.add(new Prenda("Gucci","Camisa"));
        prendas.add(new Prenda("Adidas","Pants"));

        int indice= g.guardarPrendas(prendas);

        g.mostrarPrendas();
    }
}
