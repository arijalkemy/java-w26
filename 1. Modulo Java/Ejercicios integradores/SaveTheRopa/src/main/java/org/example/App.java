package org.example;

/**
 * Hello world!
 *
 */
import java.util.*;
public class App{
    public static void main(String[] args) {
        GuardaRopa guardaRopa = new GuardaRopa();
        Prenda prenda1 = new Prenda("Nike", "Camiseta");
        Prenda prenda2 = new Prenda("Adidas", "Pantalón");

        // Guardar prendas
        int identificador = guardaRopa.guardarPrendas(Arrays.asList(prenda1, prenda2));
        System.out.println("Prendas guardadas bajo el identificador: " + identificador);

        // Mostrar todas las prendas
        guardaRopa.mostrarPrendas();

        // Devolver prendas
        List<Prenda> prendasRecuperadas = guardaRopa.devolverPrendas(identificador);
        System.out.println("Prendas devueltas:");
        prendasRecuperadas.forEach(System.out::println);
    }
}
