package org.example;

public class Distribuidora {
   public static void main(String[] args){
       Producto[] listaProductos = new Producto[5];
       listaProductos[0] = new Perecedero("Leche", 1.5, 1);
       listaProductos[1] = new Perecedero("Pan", 1.0, 2);
       listaProductos[2] = new Perecedero("Carne", 2.0, 3);
       listaProductos[3] = new NoPerecedero("Arroz", 1.0, "Grano");
       listaProductos[4] = new NoPerecedero("Sal", 0.5, "Condimento");

       for(Producto p: listaProductos){
           System.out.println("Del producto "+p.nombre+", este fue el total "+p.calcular(5));
       }
   }
}
