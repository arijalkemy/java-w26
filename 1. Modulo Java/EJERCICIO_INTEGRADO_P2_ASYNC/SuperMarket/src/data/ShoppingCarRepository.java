package data;

import java.util.ArrayList;
import java.util.List;

import models.Product;

public class ShoppingCarRepository {
    
    private static List<Product> shoppingCar = new ArrayList<>();

    public static void addItem(Product item)
    {
        shoppingCar.add(item);
    }
    public static List<Product> getShoppingCar(){
        return shoppingCar;
    }
}
