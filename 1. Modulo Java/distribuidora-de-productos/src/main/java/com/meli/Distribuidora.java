package com.meli;

import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 *
 */
public class Distribuidora
{
    public static void main( String[] args )
    {
        List<Producto> productos = new ArrayList<>();
        productos.add(new Perecedero("Manzanas", 2.5, 1));
        productos.add(new Perecedero("Lechuga", 1.8, 2));
        productos.add(new Perecedero("Pan", 3.0, 3));
        productos.add(new NoPerecedero("Arroz", 5.0, "Granos"));
        productos.add(new NoPerecedero("Aceite", 8.0, "Condimentos"));

        Integer cantidad = 5;
        Double precioTotal = productos.stream().mapToDouble(p -> p.calcular(cantidad)).sum();

        System.out.println("Precio total al vender " + cantidad + " productos de cada tipo: $" + precioTotal);
    }
}
