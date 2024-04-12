package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Supermercado supermercado = new Supermercado();

        Cliente td = new Cliente("42951261", "Tomás", "Donzis");
        Cliente sd = new Cliente("12345678", "Sol", "Donzis");
        Cliente nm = new Cliente("87654321", "Norma", "Metzger");

        supermercado.registrarCliente(td);
        supermercado.registrarCliente(sd);
        supermercado.registrarCliente(nm);

        // supermercado.mostrarClientes();

        supermercado.eliminarCliente(td);

        // supermercado.mostrarClientes();

        Scanner teclado = new Scanner(System.in);
        System.out.println("Ingrese el dni que desea buscar: ");
        supermercado.buscarClientePorDNI(teclado.nextLine());
        System.out.println("Ingrese el dni que desea buscar: ");
        supermercado.buscarClientePorDNI(teclado.nextLine());
    }
}
