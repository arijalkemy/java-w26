package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Prenda prenda_uno = new Prenda("AC","L");
        Prenda prenda_dos = new Prenda("GG","M");
        List<Prenda> prendas = new ArrayList<>();
        List<Prenda> prendasDos = new ArrayList<>();

        prendas.add(prenda_uno);
        prendas.add(prenda_dos);
        prendasDos.add(prenda_uno);
        prendasDos.add(prenda_dos);

        //HashMap<Integer,List<Prenda>> ropero_uno = new HashMap<>();
        //HashMap<Integer,List<Prenda>> ropero_dos = new HashMap<>();
        GuardaRopa guardaRopa = new GuardaRopa();

        guardaRopa.guardarPrendas(prendas);
        guardaRopa.guardarPrendas(prendasDos);

        guardaRopa.mostrarPrendas();

        System.out.println("Se devuelven las siguientes prendas:");

        System.out.println(guardaRopa.devolverPrendas(1));
        }
}