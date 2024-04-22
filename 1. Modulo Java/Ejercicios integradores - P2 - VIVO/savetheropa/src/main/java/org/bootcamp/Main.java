package org.bootcamp;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        GuardaRopa inventario = new GuardaRopa();
        Scanner scanner = new Scanner(System.in);

        inventario.guardarPrendas(List.of(new Prenda("Nike", "Air Jordan 1"), new Prenda("Adidas", "Yeezy 350")));
        System.out.println("----------------******----------------");
        inventario.mostrarPrendas();
        System.out.println("----------------******----------------");
        inventario.guardarPrendas(List.of(new Prenda("Nike", "Air Jordan 2"), new Prenda("Puma", "RS-X"),new Prenda("Adidas", "Yeezy 700")));
        System.out.println("----------------******----------------");
        inventario.mostrarPrendas();
        System.out.println("----------------******----------------");
        System.out.println("Ingrese el número de la orden para devolver las prendas");
        System.out.println("la orden ingresada tiene las siguientes prendas " + inventario.devolverPrendas(scanner.nextInt()));

    }
}