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
        List<Producto> productList = new ArrayList<>();

        Producto product1  = new Perecedero("Lechuga", 10.0, 1);
        Producto product2 = new NoPerecedero("Ketchup", 11.0, "embutido");
        Producto product3  = new Perecedero("Manzana", 12.0, 2);
        Producto product4 = new NoPerecedero("Mayonesa", 23.0, "embutido");
        Producto product5  = new Perecedero("Pepino", 20.0, 3);

        productList.add(product1);
        productList.add(product2);
        productList.add(product3);
        productList.add(product4);
        productList.add(product5);

        for (Producto product : productList) {
            System.out.println(product.toString() + product.getNombre() + ": " + product.Calcular(1));
        }

    }
}
