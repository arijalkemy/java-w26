package org.example;

import org.example.model.Cliente;

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
        Cliente cliente1 = new Cliente(12345L, "pedro1", "arriaga1");
        Cliente cliente2 = new Cliente(123456L, "pedro2", "arriaga2");
        Cliente cliente3 = new Cliente(1234567L, "pedro3", "arriaga3");

        List<Cliente> listaClientes = new ArrayList<>();
        listaClientes.add(cliente1);
        listaClientes.add(cliente2);
        listaClientes.add(cliente3);

        for (Cliente cliente : listaClientes) {
            System.out.println("----------------------------");
            System.out.println("Dni: " + cliente.getDni());
            System.out.println("nombre: " + cliente.getNombre());
            System.out.println("apellido: " + cliente.getApellido());
        }

        Scanner teclado = new Scanner(System.in);
        System.out.println("ingresa el dni para borrar: ");
        int dniPorBorrar = Integer.parseInt(teclado.nextLine());

        for (Cliente cliente : listaClientes) {
            if (cliente.getDni() == dniPorBorrar) {
                listaClientes.remove(cliente);
                System.out.println("cliente removido");
                break;
            }else {
                System.out.println("cliente no encontrado");
            }
        }

        System.out.println("ingresa el dni para buscar: ");
        int dniBuscar = Integer.parseInt(teclado.nextLine());

        for (Cliente cliente : listaClientes) {
            if (cliente.getDni() == dniBuscar) {
                System.out.println("cliente encontrado");
                System.out.println("Dni: " + cliente.getDni());
                System.out.println("nombre: " + cliente.getNombre());
                System.out.println("apellido: " + cliente.getApellido());
                break;
            }else {
                System.out.println("cliente no encontrado");
            }
        }
    }
}
