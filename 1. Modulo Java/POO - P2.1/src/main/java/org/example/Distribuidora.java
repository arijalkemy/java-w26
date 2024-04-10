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
        Producto prodNoPerecedero = new NoPerecedero("Spaghetti",2500, "Fideos");
        Producto prodPerecedero = new Perecedero("Salsa de Tomate",3500,4);

        double total = prodPerecedero.calcular(5) + prodNoPerecedero.calcular(5);
        System.out.println("Precio total: " + total);
    }
}
