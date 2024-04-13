package com.example.store;

public class Product {
    private String productCode;
    private String name;
    private double cost;
    private int quantity;

    public Product() {

    }

    public Product(String productCode, String name, double cost, int quantity) {
        this.productCode = productCode;
        this.name = name;
        this.cost = cost;
        this.quantity = quantity;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public double getCost() {
        return cost;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return  "\n"+ "[ Código de Producto: " + this.getProductCode() + " ]" +
                "[ Nombre: " + this.getName() + " ]" +
                "[ CostoxUnidad: " + this.getCost() + " ]" +
                "[ Cantidad: " + this.getQuantity() + " ]";
    }

}
