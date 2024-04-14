package org.example;

import org.example.Productos.NoPerecedero;
import org.example.Productos.Perecedero;
import org.example.Productos.Producto;

import java.util.ArrayList;
import java.util.List;

public class Disctribuidora {

    public static void main(String[] args) throws IllegalAccessException {

        System.out.println("------------------------------------------");
        //metodoExceptiones();
        System.out.println("------------------------------------------");

        List<Producto> productos = getProductos();

        // Total de vender 5 productos de cada tipo
        int cantProductos = 5;
        double total = 0;
        for(Producto productoVar : productos) {
            total = total + productoVar.calcular(cantProductos);
            System.out.println("Valor de " + cantProductos + " productos de " + productoVar.getNombre() + " es $" + productoVar.getPrecio());
        }
        System.out.println("------------------------------------------");
        System.out.println("El total vendido es de $" + total);

    }

    public static void metodoExceptiones() throws IllegalAccessException {
        PracticaExcepciones practicaExcepciones = new PracticaExcepciones();
        practicaExcepciones.calcularCociente();
    }
    private static List<Producto> getProductos() {
        List<Producto> productos = new ArrayList<>();

        Perecedero perecedero1 = new Perecedero("Queso", 3500, 1);
        Perecedero perecedero2 = new Perecedero("Milanesa", 2700, 2);
        Perecedero perecedero3 = new Perecedero("Tomate", 500, 3);
        NoPerecedero noPerecedero = new NoPerecedero("Fideos", 1050, "Largo");
        Producto producto = new Producto("Vaso", 2800);


        productos.add(perecedero1);
        productos.add(perecedero2);
        productos.add(perecedero3);
        productos.add(noPerecedero);
        productos.add(producto);
        return productos;
    }
}