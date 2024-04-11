package org.example;

import java.util.ArrayList;
import java.util.List;

public class Distribuidora {
    public static void main(String[] args) {

        ArrayList<Producto> productos = new ArrayList<>();
        productos.add(new Perecedero("leche", 5000, 180));
        productos.add(new Perecedero("Huevos", 1000, 2));
        productos.add(new NoPerecedero("arroz", 500, "fino"));
        productos.add(new NoPerecedero("Miel", 200, "pura"));
        productos.add(new Perecedero("Pan", 400, 10));

        double totalVenta = 0;
        for (Producto producto : productos) {
            totalVenta += producto.calcular(3);
        }
        System.out.println("El total de venta es: " + totalVenta);
    }
}

