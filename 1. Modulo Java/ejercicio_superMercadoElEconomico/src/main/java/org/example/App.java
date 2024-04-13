package org.example;

import org.example.classes.Cliente;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App
{
    public static void main( String[] args )
    {
        // Se crean los clientes y se guardan a la colección
        Cliente cliente1 = new Cliente(12345678, "Lionel", "Messi");
        Cliente cliente2 = new Cliente(12345677, "Guillermo", "Francella");
        Cliente cliente3 = new Cliente(12345679, "Hernan", "Rodriguez");

        List<Cliente> clientes = new ArrayList<Cliente>();
        clientes.add(cliente1);
        clientes.add(cliente2);
        clientes.add(cliente3);

        System.out.println("---------- Datos de los clientes ----------");
        clientes.forEach(System.out::println);

        System.out.println("Ingrese el Dni del cliente que desea borrar: ");
        Scanner scn = new Scanner(System.in);
        String dniInputDelete = scn.next().trim();
        List<Cliente> resultadoDelete = clientes
                .stream()
                .filter(cliente -> cliente.getDni() == Integer.valueOf(dniInputDelete))
                .toList();

        if (resultadoDelete.size() == 0) {
            System.out.println("No se encontraron resultados para el Dni ingresado.");
        } else {
            clientes.remove(resultadoDelete.get(0));
            System.out.println("Cliente borrado exitosamente.");
        }

        clientes.forEach(System.out::println);

        System.out.println("\nIngrese el Dni del cliente: ");
        String dniInput = scn.next().trim();
        List<Cliente> resultado = clientes
                .stream()
                .filter(cliente -> cliente.getDni() == Integer.valueOf(dniInput))
                .toList();

        if (resultado.size() == 0) {
            System.out.println("No se encontraron resultados para el Dni ingresado.");
        } else {
            System.out.println(resultado.get(0).toString());
        }
    }
}
