package org.example;

import java.util.ArrayList;
import java.util.List;

public class Distribuidora {
    ArrayList<Producto> productos;

    public Distribuidora(){
        this.productos = new ArrayList<Producto>();
    }

    public void llenarLista(){
        Producto p1 = new Perecedero("Chocolate", 50, 3);
        Producto p2 = new Perecedero("Queso", 150, 2);
        Producto p3 = new Perecedero("Leche", 70, 1);
        Producto p4 = new NoPerecedero("Arroz", 10, "Comestible");
        Producto p5 = new NoPerecedero("Lentejas", 15, "Comestible");
        this.productos.add(p1);
        this.productos.add(p2);
        this.productos.add(p3);
        this.productos.add(p4);
        this.productos.add(p5);
    }

    public void imprimirPrecio(){
        for (Producto producto : this.productos) {
            System.out.println(producto.calcular(1));
        }
    }
}
