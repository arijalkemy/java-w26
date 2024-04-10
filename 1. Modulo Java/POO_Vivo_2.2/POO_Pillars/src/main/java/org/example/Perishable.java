package org.example;

public class Perishable extends Product {
    int daysLeft;

    public Perishable(String name, double price, int daysLeft) {
        super(name, price);
        this.daysLeft = daysLeft;
    }

    public int getDaysLeft() {
        return daysLeft;
    }

    public void setDaysLeft(int daysLeft) {
        this.daysLeft = daysLeft;
    }

    @Override
    public double calculate(int quantityProducts) {
        double fullPrice = super.calculate(quantityProducts);
        if (this.daysLeft == 1) fullPrice = fullPrice / 4;
        if (this.daysLeft == 2) fullPrice = fullPrice / 3;
        if (this.daysLeft == 3) fullPrice = fullPrice / 2;

        return fullPrice;
    }

    @Override
    public String toString() {
        return "Perishable{" +
                "daysLeft=" + daysLeft +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
