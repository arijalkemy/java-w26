package org.example;

import org.example.Clases.AdministradorCliente;
import org.example.Clases.Cliente;
import org.example.Clases.Factura;

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
        //SPRINT 1

        Cliente cliente1 = new Cliente(42333555L, "Marcos", "Bellotti");
        Cliente cliente2 = new Cliente(40231555L, "Juan", "Zbrun");
        Cliente cliente3 = new Cliente(42332555L, "Pedro", "Rodriguez");

        List<Cliente> clientes = new ArrayList<>();
        clientes.add(cliente1);
        clientes.add(cliente2);
        clientes.add(cliente3);

        //Creo una instancia de administrador cliente para administrarlos
        AdministradorCliente administradorCliente = new AdministradorCliente(clientes);

        System.out.println("Lista original: ");
        administradorCliente.getClientes().forEach(System.out::println);

        administradorCliente.delete(cliente2);

        System.out.println("Lista con un cliente borrado: ");
        administradorCliente.getClientes().forEach(System.out::println);

        Scanner teclado = new Scanner(System.in);
        System.out.println("Ingrese un dni a buscar: ");
        Long dni = teclado.nextLong();

        Optional<Cliente> clienteBuscado = administradorCliente.findById(dni);

        //Si encuentra al cliente lo muestra, sino no
        clienteBuscado.ifPresent(cliente-> System.out.println(cliente.toString()));
        if(clienteBuscado.isEmpty())
            System.out.println("No se encontro el cliente");

        //SPRINT 2
        Factura factura = new Factura();


    }
}
