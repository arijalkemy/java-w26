package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        List<Cliente> clientes = new ArrayList<>();
        clientes.add(new Cliente("42123123", "John", "Doe"));
        clientes.add(new Cliente("43123123", "Jane", "Doe"));
        clientes.add(new Cliente("45123123", "Paul", "Smith"));

        clientes.forEach(c -> System.out.println(c.toString()));
        System.out.println("\n");

        clientes.remove(0);
        clientes.forEach(c -> System.out.println(c.toString()));

        Scanner teclado = new Scanner(System.in);
        System.out.print("Ingresar DNI a borrar de la base de datos de clientes: ");
        String dni = teclado.nextLine();
        boolean existeCliente = false;
        for (Cliente cliente : clientes) {
            if (cliente.getDni().equals(dni)) {
                clientes.remove(cliente);
                existeCliente = true;
                System.out.println("Cliente eliminado: " + cliente.toString());
            }
        }
        if (!existeCliente) {
            System.out.println("El cliente indicado no existe");
        }

        System.out.print("\nIngresar DNI del cliente a buscar: ");
        String dniBusqueda = teclado.nextLine();
        existeCliente = false;
        for (Cliente cliente : clientes) {
            if (cliente.getDni().equals(dniBusqueda)) {
                System.out.println(cliente.toString());
                existeCliente = true;
            }
        }

        if (!existeCliente) {
            System.out.println("El cliente indicado no existe");
        }

        // Parte 2
        Item pan = new Item("01", "Pan", 2, 100);
        Item huevos = new Item("02", "Huevos", 6, 50);
        ArrayList<Item> items = new ArrayList<>();
        items.add(pan);
        items.add(huevos);
        RepositorioClientes repositorio = new RepositorioClientes();
        Factura factura = new Factura(clientes.get(0), items, repositorio);
        System.out.println("Factura al cliente: " + factura.getCliente().getDni() + " por un monto de " + factura.getMontoTotal());

    }
}

