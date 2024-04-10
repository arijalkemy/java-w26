package org.example.POO_P2_VIVO;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Distributor {

    public static void main(String[] args) {
        Random rand = new Random();
        List<Product> productList = new ArrayList<>();

        String[] perishable = {"manzana", "pera", "uva", "sandia", "melon"};
        String[] nonPerishable = {"enlatado", "caja", "botella", "paquete", "bolsa"};

        for (int i = 0; i < 10; i++) {
            if (i < 5) {
                Product productPerishable = new Perishable(perishable[i], rand.nextInt(50) + 5, rand.nextInt(10) + 1);
                productList.add(productPerishable);
            } else {
                Product productNonPerishable = new NonPerishable(nonPerishable[(i - 5)], rand.nextInt(100) + 50, "nonPerishable");
                productList.add(productNonPerishable);
            }
        }

        for (Product product : productList) {
            System.out.println(
                    product.getClass().getSimpleName()
                            .concat(" -> ")
                            .concat(product.getName())
                            .concat(" -> ")
                            .concat(String.valueOf(product.calculate(5)))
            );
        }
    }
}
