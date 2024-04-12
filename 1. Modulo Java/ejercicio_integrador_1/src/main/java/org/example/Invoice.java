package org.example;

import java.util.List;

public class Invoice {
    private Client client;
    private List<Item> itemList;
    private double total;

    public Invoice(Client client, List<Item> itemList) {
        this.client = client;
        this.itemList = itemList;
        this.total = getTotal(itemList);
    }

    private double getTotal(List<Item> itemList) {
        return itemList.stream()
                .mapToDouble(Item::getItemTotal)
                .sum();
    }

    public void printDetails() {
        System.out.println(client.getFullName()+" -> "+total);
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<Item> getItemList() {
        return itemList;
    }

    public void setItemList(List<Item> itemList) {
        this.itemList = itemList;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
