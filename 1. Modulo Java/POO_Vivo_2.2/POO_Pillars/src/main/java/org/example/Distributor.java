package org.example;
import java.util.ArrayList;
import java.util.List;

public class Distributor
{
    public static void main( String[] args ) {
        List<Product> listProducts = new ArrayList<>();
        Product milk = new Perishable("Milk", 4000, 3);
        Product cheese = new Perishable("Cheese", 8000, 2);
        Product batteries = new Product("Batteries", 5500);
        Product rice = new NonPerishable("Rice", 7500, "Grain");

        listProducts.add(milk);
        listProducts.add(cheese);
        listProducts.add(batteries);
        listProducts.add(rice);

        for (Product p : listProducts) {
            System.out.println(p.calculate(5));
        }
    }
}
