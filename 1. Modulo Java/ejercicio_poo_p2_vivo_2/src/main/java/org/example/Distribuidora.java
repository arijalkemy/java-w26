package org.example;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 *
 */
public class Distribuidora {
    public static void main( String[] args ) {
        List<Producto> productos = new ArrayList<Producto>() {{
            add(new NoPerecedero("Fideos", 100, "Harinas"));
            add(new NoPerecedero("Arroz", 50, "Granos"));
            add(new NoPerecedero("Lentejas", 40, "Granos"));
            add(new NoPerecedero("Porotos", 70, "Granos"));
            add(new NoPerecedero("Avena", 40, "Cereales"));
            add(new Perecedero("Queso Azul", 170, 3));
            add(new Perecedero("Queso Reggianito", 200, 1));
            add(new Perecedero("Queso Danbo", 140, 2));
            add(new Perecedero("Jamon Cocido", 150, 2));
            add(new Perecedero("Jamon Crudo", 175, 3));
        }};

        for(Producto producto : productos) {
            System.out.println("El precio total de vender 5 productos de tipo: " + producto.toString() + " es $" + String.format("%.2f", producto.calcular(4)));
        }

    }
}
