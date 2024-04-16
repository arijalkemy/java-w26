package com.bootcamp.productos;

/**
 * Hello world!
 *
 */
public class Distribuidora {
    public static void main( String[] args )
    {
        Producto[] productos = new Producto[5];
        productos[0] = new Perecedero("Leche", 2.5, 1);
        productos[1] = new Perecedero("Pan", 1.5, 2);
        productos[2] = new Perecedero("Carne", 5.0, 3);
        productos[3] = new NoPercedero("Papel", 1.0, "Higienico");
        productos[4] = new NoPercedero("Jabon", 2.0, "Lavadora");

        for (Producto producto : productos) {
            System.out.println("Producto: " + producto.getNombre() + ", Precio total: " + producto.calcular(5));
        }
    }
}
