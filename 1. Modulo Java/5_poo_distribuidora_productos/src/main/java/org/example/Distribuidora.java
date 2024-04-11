package org.example;

import java.util.ArrayList;
import java.util.List;

public class Distribuidora {
    public static void main(String[] args) {
        List<Producto> productos = new ArrayList<>();
        // Constante creada en 1000 con la finalidad de validar fácilmente que las cuentas sean correctas.
        final double PRODUCT_PRICE = 1000.00;

        // 5 productos Perecederos
        Producto queso = new Perecedero(PRODUCT_PRICE, "Queso", 1);
        Producto cocaCola = new Perecedero(PRODUCT_PRICE, "Coca Cola", 2);
        Producto carne = new Perecedero(PRODUCT_PRICE, "Carne", 3);
        Producto ketchup = new Perecedero(PRODUCT_PRICE, "Ketchup", 4);
        Producto chocolate = new Perecedero(PRODUCT_PRICE, "Chocolate", 5);
        productos.add(queso);
        productos.add(cocaCola);
        productos.add(carne);
        productos.add(ketchup);
        productos.add(chocolate);

        // 5 productos NoPerecederos
        Producto harina = new NoPerecedero(PRODUCT_PRICE,"Harina","000");
        Producto arroz = new NoPerecedero(PRODUCT_PRICE,"Arroz","Yamani");
        Producto lecheEnPolvo = new NoPerecedero(PRODUCT_PRICE,"Leche en polvo","lacteo en polvo");
        Producto sopaInstantanea = new NoPerecedero(PRODUCT_PRICE,"Sopa Instantanea","Zapallo");
        Producto fideos = new NoPerecedero(PRODUCT_PRICE,"Fideos","Pasta");
        productos.add(harina);
        productos.add(arroz);
        productos.add(lecheEnPolvo);
        productos.add(sopaInstantanea);
        productos.add(fideos);

        // Recorro e imprimo cada valor y sus precios
        double perecederoTotal = 0.0;
        double noPerecederoTotal = 0.0;

        for(Producto producto: productos) {
            if(producto instanceof Perecedero) {
                perecederoTotal += producto.calcular(5);
                continue;
            }
            noPerecederoTotal += producto.calcular(5);
        }

        System.out.println("5 productos de cada tipo creados y 'cantidadDeProductos' (stock) en cada caso -> 5");
        System.out.println("Total costo de perecedero: $ " + perecederoTotal);
        System.out.println("Total costo de NoPerecedero: $ " + noPerecederoTotal);
    }
}