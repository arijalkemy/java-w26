package meli.bootcamp;

import java.util.*;

/**
 * Hello world!
 */
public class Distribuidora {
    public static void main(String[] args) {
        List<Producto> productos = new ArrayList<Producto>();
        productos.add(new Perecedero("Manzana", 200, 7));
        productos.add(new Perecedero("Pera", 150, 1));
        productos.add(new Perecedero("Banana", 300, 3));
        productos.add(new NoPerecedero("Atun", 3000, "pescado"));
        productos.add(new Producto("Mouse", 15000));

        for (Producto producto : productos) {
            System.out.printf("Llevando 5 unidades de %s, vas a pagar un total de %s\n", producto.getNombre(), producto.calcular(5));
        }
    }
}
