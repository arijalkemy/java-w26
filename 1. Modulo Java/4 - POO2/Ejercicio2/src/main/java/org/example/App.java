package org.example;

import java.util.ArrayList;
import java.util.Random;

public class App 
{
    public static void main( String[] args )
    {
        ArrayList<Producto> productosP = new ArrayList<Producto>();
        productosP.add(new Perecedero("Pata muslo", 10.2, 3));
        productosP.add(new Perecedero("Huevos", 6.3, 2));
        productosP.add(new Perecedero("Hamburguesa", 8.4, 1));
        productosP.add(new Perecedero("Milanesa", 12.3, 5));
        productosP.add(new Perecedero("Pechuga", 9.5, 7));

        ArrayList<Producto> productosNP = new ArrayList<Producto>();
        productosNP.add(new NoPerecedero("Choclo", 7.4, "A"));
        productosNP.add(new NoPerecedero("Lentejas", 6.9, "B"));
        productosNP.add(new NoPerecedero("Arvejas", 5.0, "C"));
        productosNP.add(new NoPerecedero("Jardinera", 8.2, "A"));
        productosNP.add(new NoPerecedero("Garbanzo", 7.7, "B"));

        // Se utiliza Random para generar una cantidad aleatoria de productos y obtener un precio
        Random random = new Random();

        double totalP = 0;
        for (Producto pr : productosP){
            totalP =+ pr.calcular(random.nextInt(10) + 1);
        }

        double totalNP = 0;
        for (Producto pr : productosNP){
            totalNP =+ pr.calcular(random.nextInt(10) + 1);
        }

        System.out.println("Total acumulado de productos Perecederos: " + totalP);
        System.out.println("Total acumulado de productos No Perecederos: " + totalNP);
    }
}
