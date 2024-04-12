package org.bootcamp;

import org.bootcamp.domain.GuardaRopa;
import org.bootcamp.domain.Prenda;

import java.util.Arrays;
import java.util.List;

/**
 * @author jsanchezpimi
 */
public class App 
{
    public static void main(String[] args) {
        // Se instancia el guarda ropa
        GuardaRopa guardaRopa = new GuardaRopa();

        // Se instancia las prendas
        Prenda camisa = new Prenda("Nike", "Camisa");
        Prenda pantalon = new Prenda("Adidas", "Pantalón");
        Prenda saco = new Prenda ("Chevignon", "Saco");
        Prenda gorra = new Prenda("Puma", "Gorra");

        // Se almacenan prendas en el guarda ropas
        Integer codigo = guardaRopa.guardarPrendas(Arrays.asList(camisa, pantalon));
        imprimirCodigo(codigo);
        Integer codigo2 = guardaRopa.guardarPrendas(Arrays.asList(saco, gorra));
        imprimirCodigo(codigo2);

        guardaRopa.mostrarPrendas();

        // Se obtiene e imprime las prendas con el codigo 2
        imprimirPrendasDevueltas(guardaRopa.devolverPrenda(codigo2));
        imprimirPrendasDevueltas(guardaRopa.devolverPrenda(3));

        // Se muestran todas las prendas que quedaron en el guarda ropa
        guardaRopa.mostrarPrendas();
    }

    private static void imprimirPrendasDevueltas(List<Prenda> listaPrendas){
        System.out.println("\n-- Prenda devuelta: --\n");
        if(listaPrendas != null)
            listaPrendas.forEach((prenda) -> System.out.println( prenda.toString()));
    }

    private static void imprimirCodigo(Integer codigo){
        System.out.println("Código asignado: " + codigo);
    }
}
