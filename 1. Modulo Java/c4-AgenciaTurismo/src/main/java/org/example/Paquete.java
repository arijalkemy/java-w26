package org.example;

import java.util.List;

public class Paquete {
    List<Item> items;

    public List<Item> getItems() {
        return items;
    }

    public Paquete setItems(List<Item> items) {
        this.items = items;
        return this;
    }
}
