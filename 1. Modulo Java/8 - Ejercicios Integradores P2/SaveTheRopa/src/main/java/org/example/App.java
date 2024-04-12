package org.example;

import org.example.model.GuardaRopa;
import org.example.model.Prenda;

import java.util.ArrayList;
import java.util.List;


public class App 
{
    public static void main( String[] args )
    {
        GuardaRopa guardaRopa = new GuardaRopa();

        Prenda prenda1 = new Prenda("Nike", "Air Force 1");
        Prenda prenda2 = new Prenda("Adidas", "Essencials");
        List<Prenda> prendaList = new ArrayList<>();
        prendaList.add(prenda1);
        prendaList.add(prenda2);

        Integer cod = guardaRopa.guardarPrendas(prendaList);
        System.out.println("Codigo de guardaropa: " + cod);

        System.out.println("Las prendas guardadas hasta el momento son:");
        guardaRopa.mostrarPrendas();
    }
}
