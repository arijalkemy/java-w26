package org.example;

public class NoPerishable extends Product {
    private String type;

    public NoPerishable(String type, String name, double price) {
        super(name, price);
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
