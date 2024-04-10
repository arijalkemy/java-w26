package org.ggomezr;

import java.util.ArrayList;
import java.util.List;

public class Distribuidora {
    public static void main(String[] args) {

//      Crear lista de productos
        List<Producto> productos = new ArrayList<>();

//      Crear alimentos perecederos
        Producto perecedero1 = new Perecedero("Leche", 100, 2);
        Producto perecedero2 = new Perecedero("Aceite", 80, 1);
        Producto perecedero3 = new Perecedero("Carne", 110, 3);
        Producto perecedero4 = new Perecedero("Manzana", 78, 2);
        Producto perecedero5 = new Perecedero("Zanahoria", 90, 1);

//      Agregar los alimentos perecederos a la lista de productos
        productos.add(perecedero1);
        productos.add(perecedero2);
        productos.add(perecedero3);
        productos.add(perecedero4);
        productos.add(perecedero5);

//      Crear los alimentos no perecederos
        Producto noPerecedero1 = new NoPerecedero("Legumbre", 120, "Enlatado");
        Producto noPerecedero2 = new NoPerecedero("Cereal", 50, "En carton");
        Producto noPerecedero3 = new NoPerecedero("Fruta", 100, "Enlatado");
        Producto noPerecedero4 = new NoPerecedero("Leche en polvo", 130, "En plastico");
        Producto noPerecedero5 = new NoPerecedero("Sopa", 70, "Enlatado");

//      Agregar los productos no perecederos a la lista de productos
        productos.add(noPerecedero1);
        productos.add(noPerecedero2);
        productos.add(noPerecedero3);
        productos.add(noPerecedero4);
        productos.add(noPerecedero5);

//      Inicializar variables para los calculos de total de ventas
        double ventaTotal = 0;
        double ventaPerecederos = 0;
        double ventaNoPerecederos = 0;

//      Iterar la lista de productos para hacer los calculos
        for(Producto producto: productos){

//          Calculo total de todos los productos de la lista
            ventaTotal += producto.getPrecio();

//          Calculo total por categoria
            if(producto instanceof Perecedero) ventaPerecederos += producto.getPrecio();
            if(producto instanceof NoPerecedero) ventaNoPerecederos += producto.getPrecio();
        }

//      Mostrar por pantalla los total de venta
        System.out.println("Total venta de todos los productos: $" + ventaTotal);
        System.out.println("Total venta de los productos perecederos: $" + ventaPerecederos);
        System.out.println("Total venta de los productos no perecederos: $" + ventaNoPerecederos);
    }
}