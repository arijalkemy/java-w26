package org.example.POO_P2_VIVO;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Perishable extends Product {

    int daysToExpire;

    public Perishable(String name, double price, int daysToExpire) {
        super(name, price);
        this.daysToExpire = daysToExpire;
    }

    @Override
    public double calculate(int cantProduct){
        double totalPrice = cantProduct * this.getPrice();
        switch (daysToExpire){
            case 1:
                totalPrice = totalPrice / 4;
                break;
            case 2:
                totalPrice = totalPrice / 3;
                break;
            case 3:
                totalPrice = totalPrice / 2;
                break;
            default: break;
        }
        return  totalPrice;
    }
}
