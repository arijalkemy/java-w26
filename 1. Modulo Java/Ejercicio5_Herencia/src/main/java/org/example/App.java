package org.example;

import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        //Se crea la lista de productos y se cargan los productos
        List<Producto> productos = new ArrayList<>();
        productos.add(new Perecedero("Leche", 2500, 1));
        productos.add(new Perecedero("Mango", 1000, 2));
        productos.add(new Perecedero("Carne", 5000, 3));
        productos.add(new NoPerecedero("Arroz", 2000, "Granos"));
        productos.add(new NoPerecedero("Atún", 3500, "Enlatado"));

        //Se recorre la lista y se realiza el calculo del total de la factura
        double total = 0;
        for (Producto producto : productos) {
            double calculo = producto.calcular(5);
            System.out.println(producto.toString());
            System.out.println("Total: " + calculo + "\n");
            total += calculo;
        }
        //Se imprime el total de la factura
        System.out.println("----------------------------------------");
        System.out.println("Total: " + total);
    }
}
