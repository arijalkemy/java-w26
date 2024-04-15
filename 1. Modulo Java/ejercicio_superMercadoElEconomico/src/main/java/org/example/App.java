package org.example;

import org.example.classes.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App
{
    public static void main( String[] args )
    {
        // Se crean los clientes y se guardan a la colección
        Cliente cliente1 = new Cliente(0, 12345678, "Lionel", "Messi");
        Cliente cliente2 = new Cliente(1, 12345677, "Guillermo", "Francella");
        Cliente cliente3 = new Cliente(2, 12345679, "Hernan", "Rodriguez");

        ClienteRepository clienteRepository = new ClienteRepository();
        clienteRepository.add(cliente1);
        clienteRepository.add(cliente2);
        clienteRepository.add(cliente3);

        System.out.println("---------- Datos de los clientes ----------");
        clienteRepository.getAll().forEach(System.out::println);

        System.out.println("Ingrese el Dni del cliente que desea borrar: ");
        Scanner scn = new Scanner(System.in);
        String dniInputDelete = scn.next().trim();
        List<Cliente> resultadoDelete = clienteRepository.getAll()
                .stream()
                .filter(cliente -> cliente.getDni() == Integer.valueOf(dniInputDelete))
                .toList();

        if (resultadoDelete.size() == 0) {
            System.out.println("No se encontraron resultados para el Dni ingresado.");
        } else {
            clienteRepository.delete(resultadoDelete.get(0).getId());
        }

        clienteRepository.getAll().forEach(System.out::println);

        System.out.println("\nIngrese el Dni del cliente: ");
        String dniInput = scn.next().trim();
        List<Cliente> resultado = clienteRepository.getAll()
                .stream()
                .filter(cliente -> cliente.getDni() == Integer.valueOf(dniInput))
                .toList();

        if (resultado.size() == 0) {
            System.out.println("No se encontraron resultados para el Dni ingresado.");
        } else {
            System.out.println(resultado.get(0).toString());
        }

        System.out.println("\n---------- Parte II ----------");
        List<Item> items = new ArrayList<Item>();
        Item item1 = new Item("123ABC", "Jabon en polvo", 12.5F, 3);
        Item item2 = new Item("124ABD", "Pan", 3.25F, 2);
        Item item3 = new Item("284MDS", "Coca Cola", 6.5F, 1);
        items.add(item1);
        items.add(item2);
        items.add(item3);

        Factura factura = new Factura(0, cliente1, items);
        FacturaRepository facturaRepository = new FacturaRepository();
        facturaRepository.add(factura);

        System.out.println("Factura creada: " + factura.toString());

    }
}
