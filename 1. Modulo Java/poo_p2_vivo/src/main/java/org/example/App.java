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
//        ExceptionsPractice practice = new ExceptionsPractice();
//        practice.getDivision();
        List<Product> productsList = new ArrayList<>();
        productsList.add(new Perishable("Lettuce", 12.23, 4));
        productsList.add(new Perishable("Eggs", 29.93, 1));
        productsList.add(new Perishable("Grapes", 6.00, 2));
        productsList.add(new Perishable("Milk", 8.45, 3));
        productsList.add(new Perishable("Carrots", 7.70, 6));
        productsList.add(new NonPerishable("Magnet", 33.2, "Magnet"));
        productsList.add(new NonPerishable("Concrete", 78.99, "Floor"));
        productsList.add(new NonPerishable("Samsung", 350.20, "Phone"));

        for (Product product : productsList) {
            System.out.println("Precio de " + product.getName() + " = " +product.calcular(5));
        }
    }
}
