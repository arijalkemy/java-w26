package org.example;

import org.example.model.Camiseta;
import org.example.model.GuardaRopa;
import org.example.model.Jeans;
import java.util.Arrays;


public class Main {
    public static void main(String[] args) {
        GuardaRopa guardaRopa = new GuardaRopa();
        System.out.println("Se guardo las prendas con el id: "+guardaRopa.guardarPrendas(
                Arrays.asList(
                        new Jeans("Tennis","Slim"),
                        new Camiseta("Monarca","Camiseta sin mangas"))));
        System.out.println("Se guardo las prendas con el id: "+guardaRopa.guardarPrendas(
                Arrays.asList(new Jeans("Tennis", "Oversize"))));
        guardaRopa.mostrarPrendas();
        System.out.println("-------- Impresión del las prendas con id 0 -----------");
        guardaRopa.devolverPrendas(0).forEach(System.out::println);
        System.out.println("-----------------------------------------------------");
    }
}