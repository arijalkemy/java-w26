package org.example.distribuidora;


import java.util.ArrayList;

public class Distribuidora {

    private ArrayList<Producto> arrayProductos;

    public Distribuidora(ArrayList<Producto> arrayProductos) {
        this.arrayProductos = arrayProductos;
    }

    public double calcularTotal(){
        double montoTotal = 0;
        for (Producto producto: this.arrayProductos){
            montoTotal = montoTotal + producto.calcular(5);
        }
        return montoTotal;
    }



}
