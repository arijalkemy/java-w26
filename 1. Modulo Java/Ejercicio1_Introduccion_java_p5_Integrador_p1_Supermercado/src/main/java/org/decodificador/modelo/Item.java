package org.decodificador.modelo;


import java.util.ArrayList;
import java.util.List;

public class Item {
    private int cantidad;
    private Producto producto;

    public Item(int cantidad, Producto producto) {
        this.cantidad = cantidad;
        this.producto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    @Override
    public String toString() {
        return "Item{" +
                "cantidad=" + cantidad +
                ", producto=" + producto +
                '}';
    }
}
