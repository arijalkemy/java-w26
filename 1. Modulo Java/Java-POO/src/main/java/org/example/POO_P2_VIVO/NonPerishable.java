package org.example.POO_P2_VIVO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NonPerishable extends Product {

    private String type;

    public NonPerishable(String name, double price, String type) {
        super(name, price);
        this.type = type;
    }

    @Override
    public String toString() {
        return "NonPerishable{" +
                " name='" + this.getName() + '\'' +
                ", price=" + this.getPrice() +
                ", type='" + type + '\'' +
                '}';
    }
}
