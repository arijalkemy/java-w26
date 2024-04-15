package org.example;

import org.example.ejercicio_save_the_ropa.GuardaRopa;
import org.example.ejercicio_save_the_ropa.Prenda;

import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main( String[] args ) {
        // Ejercicio Save The Ropa
        GuardaRopa guardaRopa = new GuardaRopa();

        List<Prenda> conjuntoPrendasUno = new ArrayList<Prenda>() {{
            add(new Prenda("Adidas", "Pantalon Essentials 3 Tiras"));
            add(new Prenda("Adidas", "Campera Essentials 3 Tiras"));
        }};

        List<Prenda> conjuntoPrendasDos = new ArrayList<Prenda>() {{
            add(new Prenda("Nike", "Short Nike 3 Boca"));
            add(new Prenda("Nike", "Camiseta Nike Titular Boca"));
        }};

        List<Prenda> conjuntoPrendasTres = new ArrayList<Prenda>() {{
            add(new Prenda("Asics", "Zapatillas de Correr Nimbus"));
        }};

        guardaRopa.guardarPrendas(conjuntoPrendasUno);
        guardaRopa.guardarPrendas(conjuntoPrendasDos);
        guardaRopa.guardarPrendas(conjuntoPrendasTres);
        guardaRopa.mostrarPrendas();

        System.out.println(guardaRopa.devolverPrendas(2));
    }
}
