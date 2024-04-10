package org.example;

import java.util.ArrayList;
import java.util.List;

public class Distribuidora {
    public static void main(String[] args) {
        List<Producto> productos = new ArrayList<>();
        productos.add(new Perecedero("Leche", 2500, 1));
        productos.add(new Perecedero("Mango", 1000, 2));
        productos.add(new Perecedero("Carne", 5000, 3));
        productos.add(new NoPerecedero("Arroz", 2000, "Granos"));
        productos.add(new NoPerecedero("Atún", 3500, "Enlatado"));

        double total = 0;
        for (Producto producto : productos) {
            double calculo = producto.calcular(5);
            System.out.println(producto.toString());
            System.out.println("Total: " + calculo + "\n");
            total += calculo;
        }
        System.out.println("----------------------------------------");
        System.out.println("Total: " + total);
    }
}