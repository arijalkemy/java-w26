package org.example.savetheropa;

import org.example.savetheropa.Prenda;
import org.example.savetheropa.GuardaRopa;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        GuardaRopa guardaRopa = new GuardaRopa();

        Prenda prenda1 = new Prenda("Nike", "Camiseta");
        Prenda prenda2 = new Prenda("Adidas", "Pantalón");

        List<Prenda> prendas = Arrays.asList(prenda1, prenda2);

        Integer codigo = guardaRopa.guardarPrendas(prendas);
        System.out.println("Código de guardado: " + codigo);

        guardaRopa.mostrarPrendas();

        List<Prenda> prendasRecuperadas = guardaRopa.devolverPrendas(codigo);
        System.out.println("Prendas recuperadas: " + prendasRecuperadas);
    }
}
