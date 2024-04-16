package org.bootcamp;

import org.bootcamp.domain.Cliente;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author jsanchezpimi
 */
public class App {
    static Set<Cliente> clientes;

    public static void main(String[] args) {
        // Se instancia el hashset para guardar los clientes
        clientes = new HashSet<>();

        // Se crean las instancias de los objetos de clientes
        Cliente cliente1 = new Cliente(1, "Juan", "Perez");
        Cliente cliente2 = new Cliente(2, "Jhonatan", "Sanchez");
        Cliente cliente3 = new Cliente(3, "Mauricio", "Rodriguez");

        // Se agregan los clientes a la collection
        clientes.add(cliente1);
        clientes.add(cliente2);
        clientes.add(cliente3);

        // Se imprimen los clientes
        imprimirClientes();

        // Se elimina el cliente 2 de la collection
        clientes.remove(cliente2);

        // Se imprimen los clientes actualizados
        System.out.println("\n*** Clientes actualizados ***");
        imprimirClientes();
    }

    /**
     * Metodo para imprimir la informacion de los clientes
     */
    private static void imprimirClientes() {
        clientes.forEach(cliente -> System.out.println(cliente.toString()));
    }

}