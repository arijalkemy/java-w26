package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        // Aqui se crean clientes
        Cliente cliente1 = new Cliente("1033783346", "Mario", "Lozano");
        Cliente cliente2 = new Cliente("1033123456", "Ivan", "Quiroga");
        Cliente cliente3 = new Cliente("987654321", "Elsa", "Pato");

        // se agregan al una lista
        List<Cliente> clientes = new ArrayList<>();
        clientes.add(cliente1);
        clientes.add(cliente2);
        clientes.add(cliente3);

        // imprimir datos de cada cliente
        System.out.println("Datos de cada cliente:");
        for (Cliente cliente : clientes) {
            System.out.println(cliente);
        }

        // Eliminar un cliente
        clientes.remove(cliente2);

        // Mostrar datos de los demas clientes
        System.out.println("\nClientes restantes después de eliminar uno:");
        for (Cliente cliente : clientes) {
            System.out.println(cliente);
        }

        // Buscar cliente por dni
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nIngrese el DNI del cliente a buscar: ");
        String dniBuscar = scanner.nextLine();
        boolean encontrado = false;
        for (Cliente cliente : clientes) {
            if (cliente.getDni().equals(dniBuscar)) {
                System.out.println("Cliente encontrado:");
                System.out.println(cliente);
                encontrado = true;
                break;
            }
        }
        if (!encontrado) {
            System.out.println("Cliente no encontrado.");
        }

    }
}
