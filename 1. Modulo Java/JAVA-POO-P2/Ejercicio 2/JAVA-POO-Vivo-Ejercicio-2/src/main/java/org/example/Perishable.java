package org.example;

public class Perishable extends Product {
    private int daysToExpire;

    public Perishable(int daysToExpire, String name, double price) {
        super(name, price);
        this.daysToExpire = daysToExpire;
    }

    @Override
    public double calculatePrice(int numberOfProduct){
        switch (this.daysToExpire){
            case 0:
            case 1:
                return this.getPrice()/4 * numberOfProduct;

            case 2:
                return this.getPrice()/3 * numberOfProduct;

            case 3:
                return this.getPrice()/2 * numberOfProduct;

            default:
                return this.getPrice() * numberOfProduct;
        }
    }

    public int getDaysToExpire() {
        return daysToExpire;
    }

    public void setDaysToExpire(int daysToExpire) {
        this.daysToExpire = daysToExpire;
    }
}
