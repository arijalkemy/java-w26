package org.example;

import java.util.ArrayList;
import java.util.List;

public class Factura {
    private static List<Item> items;
    Client client;
    int total;
    public Factura(Client client) {
        items = new ArrayList<>();
        this.client = client;
        total = 0;
    }

    public void setItems(List<Item> _items){
        items = _items;
    }
    public int getTotal(){
        for (Item item: items)
        {
            total += item.getPrice() * item.getQuantity();
        }
        return total;
    }
    /*
    public static void addItem(Item item){
        items.add(item);
    }
    */
}
