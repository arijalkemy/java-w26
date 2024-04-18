package org.example;

import org.example.Classes.GuardaRopa;
import org.example.Classes.Prenda;
import org.example.Classes.Remera;

import java.util.List;
import java.util.ArrayList;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {


        GuardaRopa guardaRopa = new GuardaRopa();
        Remera r = new Remera("Lacoste", "Roja xxl");
        Remera r2 = new Remera("Penguin", "Verde M");
        List<Prenda> listaPrendas = new ArrayList<Prenda>();
        listaPrendas.add(r);
        listaPrendas.add(r2);


        guardaRopa.guardarPrendas(listaPrendas);
        guardaRopa.guardarPrendas(listaPrendas);
        guardaRopa.MostrarPrendas();

        List<Prenda> prendasDevueltas =  guardaRopa.devolverPrendas(1);
        System.out.println(prendasDevueltas);

    }
}
