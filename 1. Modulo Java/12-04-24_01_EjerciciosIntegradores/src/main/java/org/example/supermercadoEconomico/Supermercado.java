package org.example.supermercadoEconomico;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Supermercado {
    public static void main(String[] args) {
        List<Cliente> clientes = new ArrayList<>();

        // Crear 3 clientes
        Cliente cliente1 = new Cliente("12345678A", "Juan", "Pérez");
        Cliente cliente2 = new Cliente("87654321B", "Ana", "Gómez");
        Cliente cliente3 = new Cliente("11223344C", "Luis", "Martínez");

        // Guardarlos en una colección
        clientes.add(cliente1);
        clientes.add(cliente2);
        clientes.add(cliente3);

        // Recorrer la colección de clientes y mostrar por pantalla los datos de cada uno de ellos
        System.out.println("Clientes:");
        for (Cliente cliente : clientes) {
            System.out.println(cliente);
        }

        // Eliminar uno de los clientes de la lista y volver a consultar e imprimir todos los clientes restantes
        clientes.remove(cliente2);
        System.out.println("\nClientes después de eliminar uno:");
        for (Cliente cliente : clientes) {
            System.out.println(cliente);
        }

        // Solicitar por teclado un número de dni de un cliente para buscarlo
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nIngrese el DNI del cliente a buscar: ");
        String dni = scanner.nextLine();
        boolean encontrado = false;
        for (Cliente cliente : clientes) {
            if (cliente.getDni().equals(dni)) {
                System.out.println("Cliente encontrado: " + cliente);
                encontrado = true;
                break;
            }
        }
        if (!encontrado) {
            System.out.println("Cliente no encontrado.");
        }
    }
}
