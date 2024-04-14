package org.example;

import java.util.ArrayList;
import java.util.Collection;
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
        List<Cliente> clientes = new ArrayList<>();

        clientes.add(new Cliente("1234567", "Cliente 1", "Apellido 1"));
        clientes.add(new Cliente("1234890", "Cliente 2", "Apellido 2"));
        clientes.add(new Cliente("1234986", "Cliente 3", "Apellido 3"));

        System.out.println("Clientes Original");
        for (Cliente cliente : clientes) {
            System.out.println(cliente.toString());
        }

        clientes.remove(1);
        System.out.println("Clientes despues de eliminar 1");
        for (Cliente cliente : clientes) {
            System.out.println(cliente.toString());
        }

        Scanner searchDni = new Scanner(System.in);

        System.out.print("Que usuario estas Buscando: ");
        String dni= searchDni.nextLine();
        System.out.println(dni);

        Cliente cliente =  Cliente.consultaCliente(clientes, dni);

        if (cliente == null){
            System.out.println("No se encontro un cliente");
        }else{
            System.out.println(cliente);
        }


    }
}
