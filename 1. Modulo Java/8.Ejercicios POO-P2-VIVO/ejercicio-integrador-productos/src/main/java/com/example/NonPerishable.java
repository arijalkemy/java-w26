package com.example;

public class NonPerishable extends Product{

    private String type;

    public NonPerishable(String name, double price, String type){
        super(name, price);
        this.type = type;
    }
    
    public void setType(String type) {
        this.type = type;
    }
    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return super.toString() + "\n" + "Tipo: " + this.getType();
    }




}
