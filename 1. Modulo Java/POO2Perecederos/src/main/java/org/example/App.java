package org.example;

import java.util.ArrayList;

/**
 * Hello world!
 *
 */
public class App
{
    public static void main( String[] args )
    {

        ArrayList<Producto> productosPerecedero = new ArrayList<>();


        productosPerecedero.add( new Perecedero(10, "platano", 1));
        productosPerecedero.add( new Perecedero(10, "uva", 1));
        productosPerecedero.add( new Perecedero(10, "tomate", 1));
        productosPerecedero.add( new Perecedero(10, "cebolla", 1));

        ArrayList<Producto> productosNoPerecedero = new ArrayList<>();
        productosNoPerecedero.add( new NoPerecedero(100, "tv", "casa"));
        productosNoPerecedero.add( new NoPerecedero(120, "celular", "casa"));
        productosNoPerecedero.add( new NoPerecedero(130, "pc", "casa"));
        productosNoPerecedero.add( new NoPerecedero(140, "monitor", "casa"));
        productosNoPerecedero.add( new NoPerecedero(150, "sala", "casa"));

        double totalProductosPerecedero = 0;
        for (Producto producto : productosPerecedero) {
            totalProductosPerecedero += producto.calcular(1);
        }

        double totalProductosNoPerecedero = 0;
        for (Producto productoNoPre : productosNoPerecedero) {
            totalProductosNoPerecedero += productoNoPre.calcular(1);
        }

        System.out.println("total de productos Perecedero $" + totalProductosPerecedero);
        System.out.println("total de productos No Perecedero $" + totalProductosNoPerecedero);

    }
}
