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

        /* Solicitar por teclado un número de dni de un cliente para buscarlo.
        En caso de que el cliente se encuentre en la lista, mostrar sus datos,
        caso contrario, mostrar un mensaje que informe dicha situación.
         */

    }
}

