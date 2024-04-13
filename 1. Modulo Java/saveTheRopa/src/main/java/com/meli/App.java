package com.meli;

import java.util.Arrays;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Prenda prenda1 = new Prenda("Tenis", "Nike");
        Prenda prenda2 = new Prenda("Tenis", "Adidas");

        ejecutar(prenda1, prenda2);
    }

    public static void ejecutar(Prenda prenda1, Prenda prenda2) {
        GuardaRopa guardaRopa = new GuardaRopa();

        List<Prenda> prendasGuardadas = Arrays.asList(prenda1, prenda2);
        Integer id = guardaRopa.guardarPrendas(prendasGuardadas);

        System.out.println("Se guardaron las prendas con este id: " + id);

        List<Prenda> prendasConsultadas = guardaRopa.devolverPrendas(id);
        System.out.println("Se devolveron las prendas con este id: " + id);
        for (Prenda prenda: prendasConsultadas) {
            System.out.println(prenda.getModelo() + " - " + prenda.getMarca());
        }
    }
}
