package org.example;

import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 *
 */
public class Distribuidora
{
    public static void main( String[] args ) {
        // Crear una clase ejecutable llamada Distribuidora donde van a crear un array de productos,
        // imprimir el precio total al vender 5 productos de cada tipo.
        // Crear los elementos del array con los datos que quieras.
        List<Producto> productos = new ArrayList<>();
        productos.add(new Perecedero("Carne", 5500, 3));
        productos.add(new Perecedero("Manteca", 2700, 1));
        productos.add(new Perecedero("Huevos", 3100, 2));
        productos.add(new NoPerecedero("Arroz", 1500, "Cereal"));
        productos.add(new NoPerecedero("Lentejas", 900, "Legumbres"));

        double precioTotal = 0;
        for(Producto producto: productos) {
            precioTotal = precioTotal + producto.getPrecio();
        }

        System.out.println("El precio total de los productos es de: $" + precioTotal);

    }
}
