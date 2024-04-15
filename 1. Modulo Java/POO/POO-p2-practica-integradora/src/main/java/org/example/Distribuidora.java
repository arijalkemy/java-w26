package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Hello world!
 *
 */
public class Distribuidora
{
    public static void main( String[] args )
    {

        List<Producto> productos = Arrays.asList(
                new Perecedero("Almojabana",3500,4),
                new Perecedero("Pan de bono",2700,3),
                new Perecedero("Doritos",2300,30),
                new Perecedero("Leche",5000,2),
                new Perecedero("Avena",4200,1),
                new NoPerecedero("Atún", 4300, "Enlatado"),
                new NoPerecedero("Arroz", 1500, "Grano"),
                new NoPerecedero("Miel", 10000, "Mermelada"),
                new NoPerecedero("Maní", 1000, "Frutos secos"),
                new NoPerecedero("Chocolate negro", 3000, "Dulce")
                );

        for (Producto producto: productos) {
            System.out.println("total de " + producto.getNombre() + ": " + producto.calcular(5));
        }
    }
}
