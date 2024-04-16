package org.example;

import org.example.model.GuardaRopa;
import org.example.model.Prenda;

import java.util.ArrayList;
import java.util.List;

public class App
{
    public static void main( String[] args )
    {
        Prenda prenda = new Prenda("Levis", "Pantalon");
        Prenda prenda2 = new Prenda("Wrangler", "Campera");
        List<Prenda> prendas = new ArrayList<>();
        prendas.add(prenda);
        prendas.add(prenda2);

        GuardaRopa guardaRopa = new GuardaRopa();

        guardaRopa.guardarPrendas(prendas);

        guardaRopa.mostrarPrendas();

        List<Prenda> prendasDevueltas = guardaRopa.devolverPrendas(0);
        for(Prenda prendaDev : prendasDevueltas) {
            System.out.println("Marca: " + prendaDev.getMarca() + " " + "Modelo: " + prendaDev.getModelo());
        }
    }
}
