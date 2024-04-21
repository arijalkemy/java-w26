package org.example;

import java.util.List;

public class Distribuidora {
    public static void main(String[] args) {
        Producto producto1 = new NoPerecedero("arvejas", 1000.0, "enlatado");
        Producto producto2 = new Perecedero("lechuga", 2000.0, 3);


        List<Producto> arrayDeProductos = List.of(producto1, producto2);

        for (Producto producto : arrayDeProductos) {
            System.out.println(producto.calcular(5));
        }
    }
}
