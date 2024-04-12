package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class App
{
    public static void main( String[] args )
    {
        Cliente cliente1 = new Cliente("12345678", "Juan", "Perez");
        Cliente cliente2 = new Cliente("87654321", "Maria", "Gomez");
        Cliente cliente3 = new Cliente("45678901", "Pedro", "Martinez");

        ArrayList<Cliente> clientes = new ArrayList<>();
        clientes.add(cliente1);
        clientes.add(cliente2);
        clientes.add(cliente3);

        System.out.println("Clientes:");
        for (Cliente cliente : clientes) {
            System.out.println(cliente.toString());
        }

        clientes.remove(cliente2);

        System.out.println("Clientes restantes:");
        for (Cliente cliente : clientes) {
            System.out.println(cliente.toString());
        }

        Scanner scanner = new Scanner(System.in);
        System.out.print("\nIngrese el DNI del cliente a buscar: ");
        String dniBuscado = scanner.nextLine();

        boolean encontrado = false;
        for (Cliente cliente : clientes) {
            if (cliente.getDni().equals(dniBuscado)) {
                System.out.println("Cliente encontrado:");
                System.out.println(cliente.toString());
                encontrado = true;
                break;
            }
        }

        if (!encontrado) {
            System.out.println("Cliente no encontrado.");
        }
    }
}
