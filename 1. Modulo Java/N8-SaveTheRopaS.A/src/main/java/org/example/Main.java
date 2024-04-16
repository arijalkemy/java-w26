package org.example;
import org.example.Prendas.GuardaRopa;
import org.example.Prendas.Prenda;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        GuardaRopa guardaRopa = new GuardaRopa();

        Prenda camisa = new Prenda("Kevin", "x");
        Prenda pantalon = new Prenda("Nike", "xx");

        int codigo1 = guardaRopa.guardaPrendas(Arrays.asList(camisa, pantalon));

        System.out.println(codigo1);
        guardaRopa.mostrarPrendas();
        System.out.println(guardaRopa.devolverPrenda(codigo1));
    }
}