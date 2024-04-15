package org.example.supermercado;

import org.example.supermercado.models.Cliente;
import org.example.supermercado.repository.ClienteRepository;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ClienteRepository clientes = new ClienteRepository();

        Cliente cliente1 = new Cliente(123L,"Armando","Casas");
        Cliente cliente2 = new Cliente(342L,"Daniel","Melo");
        Cliente cliente3 = new Cliente(231L,"Augusto","Salamanca");

        clientes.create(cliente1);
        clientes.create(cliente2);
        clientes.create(cliente3);
        mostrarListaDeClientes(clientes.obtenerTodos());


        Scanner teclado = new Scanner(System.in);
        System.out.println("Ingresa un dni para eliminar de la lista de cliente: ");
        String dniEliminar = teclado.nextLine();
        clientes = clientes.stream().filter(x->!x.getDni().equals(dniEliminar)).collect(Collectors.toList());
        mostrarListaDeClientes(clientes);

        System.out.println("Ingresa un dni para imprimir de la lista de cliente: ");
        String dniBusqueda = teclado.nextLine();
        mostrarUnCliente(dniBusqueda, clientes);


    }
    public static void mostrarListaDeClientes(List<Cliente> clientes){
        for (Cliente cliente: clientes){
            System.out.println(cliente.toString());
        }
    }
    public static void mostrarUnCliente(String dni, List<Cliente> clientes){
        for (Cliente cliente:clientes){
            if(cliente.getDni().equals(dni)){
                System.out.println(cliente.toString());
                return;
            }
        }
        System.out.println("El cliente solicitado no se encontró");
    }
}
