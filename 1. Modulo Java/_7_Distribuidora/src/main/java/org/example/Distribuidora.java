package org.example;
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
        List<Producto> productos = new ArrayList<Producto>();
        Producto producto = new Perecedero("Producto perecedero", 345, 2);
        Producto productoNoPerecedero = new NoPerecedero("Producto NO perecedero", 3332, "fideos");

        productos.add(producto);
        productos.add(productoNoPerecedero);

        double total=0;

        for(int i =0; i<productos.size(); i++){
            total = total + productos.get(i).calcular(5);
        }

        System.out.println(productos);
        System.out.println(productos.size());
        System.out.println("El total es: " + total);
    }
}
