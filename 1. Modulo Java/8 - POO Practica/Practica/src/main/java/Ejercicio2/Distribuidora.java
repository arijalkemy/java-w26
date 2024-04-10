package Ejercicio2;

import java.util.ArrayList;
import java.util.List;

public class Distribuidora {
    public static void main( String[] args ) throws Exception
    {
        Producto perecedero = new Perecedero("Hamburguesa", 100.50, 2);
        Producto noPerecedero = new NoPerecedero("Lenteja", 50.00, "Legumbre");
        Producto producto = new Producto("Helado", 80.20);

        List<Producto> productos = new ArrayList<Producto>();
        productos.add(perecedero);
        productos.add(noPerecedero);
        productos.add(producto);

        double total = 0;
        for( Producto p:productos){
            System.out.println("Vendo: " + p.toString());
            total += p.calcular(5);
        }
        System.out.println("El total es: " + total);
    }
}
