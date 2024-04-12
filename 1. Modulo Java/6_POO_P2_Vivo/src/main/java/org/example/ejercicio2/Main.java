package org.example.ejercicio2;

public class Main {

    public static void main(String[] args) {

        Producto[] productos = {
            new Perecedero("Lomo", 3500, 3),
            new NoPerecedero("Jabón", 500, "Limpieza"),
            new Perecedero("Empanada", 1000, 5),
            new NoPerecedero("Fideos", 1200, "Comestible"),
            new Perecedero("Huevos", 300, 2)
        };

        for (Producto producto : productos) {
            System.out.println("\nImprimiendo producto:");
            System.out.println(producto);
            System.out.println("Precio total de 5 artículos del producto: " + producto.calcular(5));
        }
    }

}
