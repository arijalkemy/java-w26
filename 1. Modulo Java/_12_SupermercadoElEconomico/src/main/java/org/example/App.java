package org.example;

import org.example.Clases.Cliente;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Cliente cliente1 = new Cliente(42333555L, "Marcos", "Bellotti");
        Cliente cliente2 = new Cliente(40231555L, "Juan", "Zbrun");
        Cliente cliente3 = new Cliente(42332555L, "Pedro", "Rodriguez");

        List<Cliente> clientes = new ArrayList<>();
        clientes.add(cliente1);
        clientes.add(cliente2);
        clientes.add(cliente3);

        System.out.println("Lista original: ");
        clientes.forEach(System.out::println);

        clientes.remove(cliente3);

        System.out.println("Lista con un cliente borrado: ");
        clientes.forEach(System.out::println);

        Scanner teclado = new Scanner(System.in);
        System.out.println("Ingrese un dni a buscar: ");
        Long dni = teclado.nextLong();

        Optional<Cliente> clienteBuscado = clientes.stream().
                filter(c -> c.getDni().equals(dni))
                .findFirst();

        //Si encuentra al cliente lo muestra, sino no
        clienteBuscado.ifPresent(cliente-> System.out.println(cliente.toString()));
        if(clienteBuscado.isEmpty())
            System.out.println("No se encontro el cliente");

    }
}
