package org.example.POO_P2_VIVO;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Product {

    private String name;
    private double price;

    public double calculate(int cantProduct){
        return cantProduct * this.getPrice();
    }
}
