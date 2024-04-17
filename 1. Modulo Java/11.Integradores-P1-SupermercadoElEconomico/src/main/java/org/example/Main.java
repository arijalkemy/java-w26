package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Hello world!
 */
public class Main {
    public static void main(String[] args) {
        // se crea una lista con 3 clientes
        Cliente cliente1 = new Cliente(123, "Juan", "carvajal");
        Cliente cliente2 = new Cliente(1234, "pedro", "martinez");
        Cliente cliente3 = new Cliente(12345, "andres", "Garcia");

        //se imprime enpantalla la lista de clientes
        List<Cliente> listaDeClientes = new ArrayList<Cliente>(List.of(cliente1, cliente2, cliente3));
        System.out.println("#########Se imprime la lista de clientes######");
        for (Cliente cliente : listaDeClientes) {
            System.out.println("Datos del cliente: " + cliente.getNombre() + " " + cliente.getApellido());
            System.out.println("Dni: " + cliente.getDni());
        }

        //Se elimina un cliente y se vuelve a mostrar la lista de clientes
        listaDeClientes.remove(cliente2);
        System.out.println("#########Se imprime la lista de clientes######");
        for (Cliente cliente : listaDeClientes) {
            System.out.println("Datos del cliente: " + cliente.getNombre() + " " + cliente.getApellido());
            System.out.println("Dni: " + cliente.getDni());
        }

        //Se busca un cliente
        System.out.println();
        System.out.println("###### Se inicia la busqueda del cliente #####");
        System.out.println("Por favor, ingrese el dni del cliente:");
        Scanner sc = new Scanner(System.in);

        int dni = sc.nextInt();
        boolean clienteEncontrado = false;
        for (Cliente cliente : listaDeClientes) {
            if (cliente.getDni() == dni) {
                clienteEncontrado = true;
                System.out.println("Datos del cliente: " + cliente.getNombre() + " " + cliente.getApellido());
                System.out.println("Dni: " + cliente.getDni());
            }
        }
        if (!clienteEncontrado) {
            System.out.println("Cliente no encontrado en la lista de clientes");
        }
    }
}
