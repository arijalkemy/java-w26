package org.example;

import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 *
 */
public class Distribuidora
{
    public static void main( String[] args )
    {

        List<Producto> productos = new ArrayList<>();

        Producto uno = new Perecedero("Leche", 4000, 3);
        Producto dos = new NoPerecedero("Queso", 5000, "Lacteos");
        Producto tres = new Producto("Panela", 7000);
        Producto cuatro = new Perecedero("Jamon", 5000, 1);
        Producto cinco = new Perecedero("Pan Tajado", 15000, 2);

        productos.add(uno);
        productos.add(dos);
        productos.add(tres);
        productos.add(cuatro);
        productos.add(cinco);

        for(Producto p: productos){
            System.out.println(p.calcular(5));
        }



    }
}
