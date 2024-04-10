package org.example;

public class Perishable extends Product {
    private int daysToExpire;

    public Perishable(String name, double price, int daysToExpire) {
        super(name, price);
        this.daysToExpire = daysToExpire;
    }

    @Override
    public double calcular(int cantidadDeProductos) {
        double discount;
        switch (this.daysToExpire){
            case 1:
                discount = 0.25;
                break;
            case 2:
                discount = 0.33;
                break;
            case 3:
                discount = 0.5;
                break;
            default:
                discount = 1;
        }
        return (this.getPrice() * cantidadDeProductos) * discount;
    }

    public int getDaysToExpire() {
        return daysToExpire;
    }

    public void setDaysToExpire(int daysToExpire) {
        this.daysToExpire = daysToExpire;
    }

    @Override
    public String toString() {
        return "Perishable{" +
                "daysToExpire=" + daysToExpire +
                '}';
    }
}
