package org.main;
import java.util.List;
import java.util.ArrayList;

/**
 * Hello world!
 *
 */
public class Distribuidora
{
    public static void main( String[] args )
    {
        List Producto = new ArrayList();
        Producto.add(new Perecedero("Manzana", 10.0, 1));
        Producto.add(new NoPerecedero("Lavadora", 1000.0, "Electrodomestico"));
        Producto.add(new Perecedero("Leche", 2.0, 5));
        Producto.add(new NoPerecedero("Silla", 50.0, "Mueble"));
        Producto.add(new Perecedero("Pan", 1.0, 2));

        Double total = 0.0;
        for (Object producto : Producto) {
            total += ((Producto) producto).calcular(5);

        }
        System.out.println("El total es: " + total);
    }
}
