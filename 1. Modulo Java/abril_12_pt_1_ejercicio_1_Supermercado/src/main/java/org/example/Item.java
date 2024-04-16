package org.example;

public class Item {
    private String codeId;
    private String name;
    private double price;
    private int quantity;

    public Item(String codeId, String name, double price, int quantity) {
        codeId = codeId;
        name = name;
        price = price;
        quantity = quantity;
    }

    public String getCodeId() {
        return codeId;
    }

    public void setCodeId(String codeId) {
        this.codeId = codeId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
