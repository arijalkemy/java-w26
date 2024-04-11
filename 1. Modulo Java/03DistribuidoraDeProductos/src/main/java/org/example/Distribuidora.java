package org.example;

import java.util.ArrayList;
import java.util.List;

public class Distribuidora {
    public static void main(String[] args) {
        List<Producto> productos = new ArrayList<>();
        Producto perecedero = new Perecedero("Tomate", 20.5, 2);
        productos.add(perecedero);
        Producto noPerecedero = new NoPerecedero("Arroz", 50.5, "Blanco");
        productos.add(noPerecedero);

        for (Producto producto : productos) {
            System.out.println("El precio de venta de " + 5 + " productos de tipo " + producto.getNombre() + " " + producto.getClass().getSimpleName() + " es: " + producto.calcular(5));
        }
    }
}

