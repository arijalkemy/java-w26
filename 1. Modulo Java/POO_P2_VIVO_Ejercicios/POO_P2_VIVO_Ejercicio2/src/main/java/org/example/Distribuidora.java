package org.example;

import java.util.List;
import java.util.ArrayList;

public class Distribuidora
{
    public static void main( String[] args )
    {
        List<Producto> productosList = new ArrayList<Producto>();
        productosList.add(new Producto("Producto 2", 20.0));
        productosList.add(new Producto("Producto 3", 25.0));
        productosList.add(new Producto("Producto 4", 30.0));
        productosList.add(new Producto("Producto 5", 32.0));

        productosList.add(new Perecedero("Producto 5", 35.0, 1));
        productosList.add(new Perecedero("Producto 6", 40.0, 2));
        productosList.add(new Perecedero("Producto 7", 45.0, 3));
        productosList.add(new Perecedero("Producto 8", 50.0, 2));
        productosList.add(new Perecedero("Producto 9", 55.0, 1));

        productosList.add(new NoPerecedero("Producto 10", 60.0, "Electrónico"));
        productosList.add(new NoPerecedero("Producto 11", 65.0, "Mueble"));
        productosList.add(new NoPerecedero("Producto 12", 70.0, "Juguete"));
        productosList.add(new NoPerecedero("Producto 13", 75.0, "Deporte"));
        productosList.add(new NoPerecedero("Producto 14", 80.0, "Cocina"));
        double miniPrecio;
        double totalPerecedero = 0; double totalNoPerecedero = 0; double totalProductos = 0;
        for(Producto miniProducto: productosList){
            miniPrecio = miniProducto.calcular(5);
            if (miniProducto instanceof Perecedero) {
                totalPerecedero += miniPrecio;
            }
            else if (miniProducto instanceof NoPerecedero) {
                totalNoPerecedero += miniPrecio;
            }
            else {
                totalProductos += miniPrecio;
            }
        }
        System.out.println("Precio total al vender 5 productos: " + totalProductos);
        System.out.println("Precio total al vender 5 productos No Perecederos: " + totalNoPerecedero);
        System.out.println("Precio total al vender 5 productos Perecederos: " + totalPerecedero);
    }
}