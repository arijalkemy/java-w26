package org.bootcamp;

import org.bootcamp.domain.NoPerecedero;
import org.bootcamp.domain.Perecedero;
import org.bootcamp.domain.Producto;

import java.util.ArrayList;

/**
 * @author jsanchezpimi
 */
public class Distribuidora
{
    public static void main(String[] args) {
        // Se crea el array de productos y se establece el tamanio del mismo
        ArrayList<Producto> productos = new ArrayList<>();

        // Se instancian los productos Perecederos
        productos.add(new Perecedero("Leche", 2500, 1));
        productos.add(new Perecedero("Pan", 1000, 2));
        productos.add(new Perecedero("Yogur", 1700, 3));
        productos.add(new Perecedero("Frutas", 5000, 2));
        productos.add(new Perecedero("Verduras", 3400, 4));

        // Se instancian los productos No Perecederos
        productos.add(new NoPerecedero("Arroz", 1800, "Granos"));
        productos.add(new NoPerecedero("Pasta", 1750, "Granos"));
        productos.add(new NoPerecedero("Aceite", 3200, "Líquido"));
        productos.add(new NoPerecedero("Conservas", 2000, "Enlatado"));
        productos.add(new NoPerecedero("Galletas", 2500, "Dulce"));

        // Se realiza el calculo del total al vender 5 productos de cada uno
        double valorTotal = 0;

        System.out.println("\n--- Distribuidora ---\n");
        for(Producto producto : productos){
            valorTotal += producto.calcular(5);
            System.out.println(producto.toString());
        }

        System.out.println("\nPrecio total: " + valorTotal);
    }
}
