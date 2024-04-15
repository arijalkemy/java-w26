package org.example;

import java.util.ArrayList;

/**
 * Hello world!
 *
 */
public class Main
{
    public static void main( String[] args ) {
        /*
        * Ejercicio 1
        * */
        //PracticaExcepciones practica = new PracticaExcepciones();
        //practica.cociente2();
        ArrayList<Producto> productos= new ArrayList<>();
        productos.add(new NoPerecedero("Frijoles",200,"grano"));
        productos.add(new Perecedero("Leche",300,3));
        productos.add(new Perecedero("Yogourt",550,5));
        productos.add(new Perecedero("Pan",150,1));
        productos.add(new NoPerecedero("Arroz",200,"grano"));
        int cantidadDeProductos=5;
        for (Producto producto: productos){
            System.out.println(producto.toString()+", Cantidad: "+cantidadDeProductos+", SubTotal: "+producto.calcular(cantidadDeProductos));
        }

    }
}
