package org.example.POO_P2_VIVO;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class NonPerishable extends Product{

    private String type;

    public NonPerishable(String name, double price, String type) {
        super(name, price);
        this.type = type;
    }
}
