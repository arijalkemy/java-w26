package org.example;

import org.example.distribuidora.Distribuidora;
import org.example.distribuidora.NoPerecedero;
import org.example.distribuidora.Perecedero;
import org.example.distribuidora.Producto;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        ArrayList<Producto> arrayProductos = new ArrayList<>();

        Producto producto1 = new Producto("Galletitas Oreo", 2000);
        Producto producto2 = new Producto("Botella", 6000);
        Perecedero producto3 = new Perecedero("Galletitas Oreo", 2000, 2);
        Perecedero producto4 = new Perecedero("Arroz", 1500, 3);
        NoPerecedero producto5 = new NoPerecedero("Carne Vacuna", 7000, "A");

        arrayProductos.add(producto1);
        arrayProductos.add(producto2);
        arrayProductos.add(producto3);

        Distribuidora distribuidora = new Distribuidora(arrayProductos);

        double montoTotal = distribuidora.calcularTotal();
        System.out.println("El monto total es de: " + montoTotal);

    }
}