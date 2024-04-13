package org.example;

import org.example.prenda.Zapatilla;
import org.example.ropero.GuardaRopa;
import org.example.prenda.Prenda;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        GuardaRopa guardaRopa = new GuardaRopa();

        List<Prenda> listaZapatillas = new ArrayList<>();
        Prenda zapatillasVans = new Zapatilla("1001","Vans", "OldSkull");
        Prenda zapatillaAdidas = new Zapatilla("2001","Adidas", "Superstar");
        listaZapatillas.add(zapatillasVans);
        listaZapatillas.add(zapatillaAdidas);

        guardaRopa.guardarPrendas(listaZapatillas);

        // Punto 4
        guardaRopa.mostrarPrendas();

        // Punto 5
        List<Prenda> prendasConsultadas = guardaRopa.devolverPrendas(1);
        guardaRopa.imprimirPrendas(prendasConsultadas);

        // Punto 6
        List<Prenda>  listaZapatillas2 = new ArrayList<>();
        Prenda zapatillasDC = new Zapatilla("3001","DC", "Classic");
        Prenda zapatillasNike = new Zapatilla("4001","Nike", "Superfly");
        listaZapatillas2.add(zapatillasDC);
        listaZapatillas2.add(zapatillasNike);

        int ubicacionPrendas = guardaRopa.guardarPrendas(listaZapatillas2);
        List<Prenda> listaConsultada = guardaRopa.devolverPrendas(ubicacionPrendas);
        guardaRopa.imprimirPrendas(listaConsultada);


    }

}