package com.example;

public class Perishable extends Product{

    private int daysToPerish;

    public Perishable(String name, double precio, int daysToPerish){
        super(name, precio);
        this.daysToPerish = daysToPerish;
    }

    public void setDaysToPerish(int daysToPerish) {
        this.daysToPerish = daysToPerish;
    }

    public int getDaysToPerish() {
        return daysToPerish;
    }

    @Override
    public String toString() {
        return super.toString() + "\n" + "Días para caducar: " + this.daysToPerish;
    }

    @Override
    public double calculate(int numberOfProducts) {
        double finalPrice = super.calculate(numberOfProducts);
        int option = this.getDaysToPerish();
        switch (option) {
            case 1:
                finalPrice /= 4;
                break;
            case 2:
                finalPrice /= 3;
                break;
            case 3:
                finalPrice /= 2;
                break;
            default:
                break;
        }
        return finalPrice;  
    }

}
