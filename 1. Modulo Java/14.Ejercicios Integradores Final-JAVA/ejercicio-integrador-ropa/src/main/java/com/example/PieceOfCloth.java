package com.example;

public class PieceOfCloth {

    private String brand;
    private String model;

    public PieceOfCloth(){

    }
    
    public void setBrand(String brand) {
        this.brand = brand;
    }
    public String getBrand() {
        return brand;
    }

    public void setModel(String model) {
        this.model = model;
    }
    public String getModel() {
        return model;
    }

    @Override
    public String toString(){
        return "\n" +"[Marca: " + this.getBrand() + "]" + "-" +"[Modelo: " + this.getModel() + "]"; 
    }

}
