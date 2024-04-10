package org.example.POO_P2_VIVO;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Distributor {

    public static void main(String[] args) {
        Random rand = new Random();
        List<Product> productList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            if (i < 4) {
                Product productPerishable = new Perishable("manzana", 20, rand.nextInt(10));
            productList.add(productPerishable);
            } else {
            }
        }
    }
}
