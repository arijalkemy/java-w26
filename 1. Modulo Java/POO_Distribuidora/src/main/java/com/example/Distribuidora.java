package com.example;

/**
 * Hello world!
 *
 */
public class Distribuidora 
{
    public static void main( String[] args )
    {
        Producto[] productos = new Producto[] {
            new Producto("Play Station 5",150.0),
            new Perecedero("Tomates", 20.0, 6),
            new Perecedero("Pan", 10.0, 2),
            new NoPerecedero("Arroz", 10.0, "Doble carolina"),
            new NoPerecedero("Fideos", 5.0, "Moñitos")
        };

        double precioTotal = 0;
        for (Producto producto : productos) {
            precioTotal += producto.calcular(5);
        }
        System.out.printf("<< El precio total es de: %.2f%n",precioTotal);
    }
}
