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
        productosPerecedero.add( new Perecedero(5, "uva", 2));
        productosPerecedero.add( new Perecedero(8, "tomate", 3));
        productosPerecedero.add( new Perecedero(6, "cebolla", 4));

        ArrayList<Producto> productosNoPerecedero = new ArrayList<>();
        productosNoPerecedero.add( new NoPerecedero(100, "tv", "casa"));
        productosNoPerecedero.add( new NoPerecedero(120, "celular", "casa"));
        productosNoPerecedero.add( new NoPerecedero(130, "pc", "casa"));
        productosNoPerecedero.add( new NoPerecedero(140, "monitor", "casa"));
        productosNoPerecedero.add( new NoPerecedero(150, "sala", "casa"));

        int totalProductosPerecedero = 0;
        for (Producto producto : productosPerecedero) {
            totalProductosPerecedero += producto.calcular(2);
        }

        int totalProductosNoPerecedero = 0;
        for (Producto productoNoPre : productosNoPerecedero) {
            totalProductosNoPerecedero += productoNoPre.calcular(1);
        }

        System.out.println("total de productos Perecedero $" + totalProductosPerecedero);
        System.out.println("total de productos No Perecedero $" + totalProductosNoPerecedero);

    }
}
