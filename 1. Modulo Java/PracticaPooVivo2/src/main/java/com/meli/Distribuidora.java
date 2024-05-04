package com.meli;

public class Distribuidora {
    public static void main(String[] args) {
        Producto[] productos = new Producto[6];

        productos[0] = new Producto("Producto 1", 100.0);
        productos[1] = new Producto("Producto 2", 200.0);
        productos[2] = new Perecederos("Perecedero 1", 150.0, 1);
        productos[3] = new Perecederos("Perecedero 2", 250.0, 2);
        productos[4] = new NoPerecederos("No Perecedero 1", 300.0, "Tipo 1");
        productos[5] = new NoPerecederos("No Perecedero 2", 350.0, "Tipo 2");

        double total = 0;
        for (Producto producto : productos) {
            total += producto.calcular(5);
        }

        System.out.println("El precio total al vender 5 productos de cada tipo es: " + total);
    }
}