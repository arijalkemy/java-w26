package org.example;

import org.example.classes.GuardaRopa;
import org.example.classes.Prenda;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class App 
{
    public static void main( String[] args )
    {
        Prenda prenda1 = new Prenda("Nike", "Air Jordan");
        Prenda prenda2 = new Prenda("Penguin", "Chomba");
        List<Prenda> prendas = new ArrayList<Prenda>();
        prendas.add(prenda1);
        prendas.add(prenda2);

        Map<Integer, List<Prenda>> secciones = new HashMap<>();
        GuardaRopa guardaRopa = new GuardaRopa(0, secciones);

        Integer numero = guardaRopa.guardarPrendas(prendas);
        System.out.println("Se guardaron las prendas en la sección: " + numero);

        guardaRopa.devolverPrendas(1);
    }
}
