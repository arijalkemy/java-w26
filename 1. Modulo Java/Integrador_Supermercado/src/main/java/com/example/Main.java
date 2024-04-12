package com.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        // * PARTE 1
        Supermercado supermercado = new Supermercado();

        // RECORRO TODOS LOS CLIENTES
        supermercado.getClientes().forEach(System.out::print);

        // ELIMINO UN CLIENTE
        supermercado.removerClienteAleatoriamente();
        supermercado.getClientes().forEach(System.out::print);

        // BUSCAR UN CLIENTE
        Scanner out = new Scanner(System.in);
        System.out.println("Ingrese el numero de documento del usuario: ");
        String dni = out.next();
        out.close();

        System.out.println(supermercado.buscarCliente(dni));

        // * PARTE 2
        List<Producto> productos = new ArrayList<>();
        productos.add(new Producto(1,"Papas",5,10.0));
        productos.add(new Producto(2,"Queso",14,25.0));
        productos.add(new Producto(3,"Empanadas",5,50.0));
        productos.add(new Producto(4,"Milanesas",30,120.0));
        Factura factura = new Factura(new Cliente("12345", "Juancito", "Vazquez"),productos);

        supermercado.cargarFactura(factura);

    }
}