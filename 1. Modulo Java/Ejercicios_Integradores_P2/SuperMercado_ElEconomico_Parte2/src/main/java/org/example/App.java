package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class App
{
    public static void main( String[] args )
    {
        ClientService clientService = new ClientService();

        Cliente cliente1 = new Cliente("12345678", "Juan", "Perez");
        Cliente cliente2 = new Cliente("87654321", "Maria", "Gomez");
        Cliente cliente3 = new Cliente("45678901", "Pedro", "Martinez");

        clientService.create(cliente1);
        clientService.create(cliente2);
        clientService.create(cliente3);

        System.out.println("Clientes:");
        for (Cliente cliente : clientService.getAll()) {
            System.out.println(cliente.toString());
        }

        clientService.delete(cliente2.getDni());

        System.out.println("Clientes restantes:");
        for (Cliente cliente : clientService.getAll()) {
            System.out.println(cliente.toString());
        }

        Scanner scanner = new Scanner(System.in);
        System.out.print("\nIngrese el DNI del cliente a buscar: ");
        String dniBuscado = scanner.nextLine();

        Cliente clienteBuscado = clientService.read(dniBuscado);
        if (clienteBuscado != null) {
            System.out.println("Cliente encontrado:");
            System.out.println(clienteBuscado);
        } else {
            System.out.println("Cliente no encontrado.");
        }

        FacturaService facturaService = new FacturaService(clientService);

        Cliente clienteNuevo = new Cliente("12345678", "Juan", "Perez");
        ArrayList<Item> items = new ArrayList<>();
        items.add(new Item(1,"Item1", 5,10.0));
        items.add(new Item(2,"Item2", 5,20.0));
        Factura factura1 = new Factura("1",clienteNuevo, items, 0);

        facturaService.create(factura1);

        System.out.println("Facturas:");
        for (Factura factura : facturaService.getAll()) {
            System.out.println(factura.toString());
        }
    }
}