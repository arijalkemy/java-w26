package org.example.entidades;

import java.util.List;

public class Paquete {
    private List<Item> itemList;

    public Paquete(List<Item> itemList) {
        this.itemList = itemList;
    }

    public List<Item> getItemList() {
        return itemList;
    }


    public Double calcularTotalDelPaquete(){
        Double totalApagar = itemList.stream()
                .mapToDouble(Item::calcularTotalItem)
                .sum();
        return totalApagar;
    }

    @Override
    public String toString() {
        return "Paquete{" +
                "itemList=" + itemList +
                '}';
    }
}
