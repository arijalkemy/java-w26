package org.example;

import model.NoPerecedero;
import model.Perecedero;
import model.Producto;

import java.util.ArrayList;
import java.util.List;

public class Distribuidora {
    public static void main(String[] args) {
        List<Producto> productos = new ArrayList<>();
        productos.add(new Producto("Generico", 1250));
        productos.add(new Perecedero("Cerveza",12500,1));
        productos.add(new Perecedero("Pan",500,2));
        productos.add(new Perecedero("Pollo",30000,3));
        productos.add(new Perecedero("Arroz",2500,4));
        productos.add(new NoPerecedero("Lapicero",1500,"Papelería"));
        productos.add(new NoPerecedero("Celular",650000, "Tecnología"));
        productos.add(new NoPerecedero("Nevera",1350000,"Electrodoméstico"));

        for(Producto producto: productos) {
            System.out.println("------------------------------");
            System.out.println(producto);
            System.out.println(producto.calcular(5));
        }
    }
}