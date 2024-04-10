package com.company;

import java.util.ArrayList;
import java.util.List;

public class Distribuidora {

    public static void main(String[] args) {
        // Se instancia el array de productos
        List<Producto> listaProductos = new ArrayList<Producto>();

        // Se instancian los producto y se añaden a la lista
        Perecedero perecedero1 = new Perecedero("Carne", 1300.50, 3);
        Perecedero perecedero2 = new Perecedero("Pan", 96.70, 2);
        Perecedero perecedero3 = new Perecedero("Leche", 103.99, 1);

        NoPerecedero noPerecedero1 = new NoPerecedero("Arroz", 110.0, "Cereal");
        NoPerecedero noPerecedero2 = new NoPerecedero("Garbanzos secos", 250.65, "Legumbre");
        NoPerecedero noPerecedero3 = new NoPerecedero("Yerba Mate", 580.99, "Infusion");

        listaProductos.add(perecedero1);
        listaProductos.add(perecedero2);
        listaProductos.add(perecedero3);
        listaProductos.add(noPerecedero1);
        listaProductos.add(noPerecedero2);
        listaProductos.add(noPerecedero3);

        // Se calcula el precio total
        double precioTotal = 0;
        for (Producto producto : listaProductos) {
            double precioProducto = producto.calcular(5);
            precioTotal += precioProducto;
        }
        
        System.out.println("Precio total de vender 5 productos de cada tipo: $" + precioTotal);
    }
}
