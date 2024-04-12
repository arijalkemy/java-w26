package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Supermercado supermercado = new Supermercado();

        Cliente pg = new Cliente("34343434", "Peter", "Griffin");
        Cliente sg = new Cliente("12345678", "Stewie", "Griffin");
        Cliente lp = new Cliente("87654321", "Lois", "Pewterschmidt");

        supermercado.registrarCliente(pg);
        supermercado.registrarCliente(sg);
        supermercado.registrarCliente(lp);

        // supermercado.mostrarClientes();

        supermercado.eliminarCliente(pg);

        // supermercado.mostrarClientes();

        Scanner teclado = new Scanner(System.in);
        System.out.println("Ingrese el dni que desea buscar: ");
        supermercado.buscarClientePorDNI(teclado.nextLine());
        System.out.println("Ingrese el dni que desea buscar: ");
        supermercado.buscarClientePorDNI(teclado.nextLine());
    }
}
