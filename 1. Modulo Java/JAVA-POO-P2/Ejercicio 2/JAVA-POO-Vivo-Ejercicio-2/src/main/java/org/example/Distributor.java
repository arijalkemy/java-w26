package org.example;

import java.util.ArrayList;

public class Distributor {
    private ArrayList<Product> productos;

    public Distributor(){
        this.productos = new ArrayList<Product>();
    }

    @Override
    public String toString(){
        for(Product product: this.productos){
            product.toString();
        }
        return "";
    }

    public ArrayList<Product> getProductos() {
        return productos;
    }

    public void setProductos(ArrayList<Product> productos) {
        this.productos = productos;
    }


}
