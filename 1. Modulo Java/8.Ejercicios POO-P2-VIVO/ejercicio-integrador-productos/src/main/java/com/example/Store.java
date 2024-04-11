package com.example;

import java.util.ArrayList;
import java.util.List;

public class Store 
{
    public static void main( String[] args )
    {
        List<Product> products = new ArrayList<Product>();

        Perishable perishableProduct = new Perishable("Banana", 10, 2);
        NonPerishable nonPerishableProduct = new NonPerishable("Arroz", 23.4, "Blanco");

        products.add(nonPerishableProduct);
        products.add(perishableProduct);

        System.out.print(
            "----------------------------------------" + "\n" + 
            "------------- PRODUCTOS ----------------" + "\n");

        for (Product product : products) {
            System.out.println("Producto: " + product.getName() + "\n" +
                               "Precio: " + product.calculate(5));
            System.out.println();
        }

    }
}
