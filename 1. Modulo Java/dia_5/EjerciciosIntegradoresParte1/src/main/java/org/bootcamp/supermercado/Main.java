package org.bootcamp.supermercado;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        //Crear 3 clientes y guardarlos en una collection.
        List<Cliente> clientes = new ArrayList<>();
        Cliente cliente1 = new Cliente(1234, "Edwin", "Guayacan");
        Cliente cliente2 = new Cliente(23456, "Juan", "Lopez");
        Cliente cliente3 = new Cliente(345678, "Jose", "Ravelo");
        clientes.add(cliente1);
        clientes.add(cliente2);
        clientes.add(cliente3);

        // Recorrer la collection de clientes y mostrar por pantalla los datos de cada uno de ellos.
        System.out.println("Clientes:");
        for (Cliente cliente : clientes) {
            System.out.println(cliente);
        }

        // Eliminar uno de los clientes de la lista y volver a consultar e imprimir todos los clientes restantes.
        clientes.remove(cliente1);
        System.out.println("Clientes después de la eliminación:");
        for (Cliente cliente : clientes) {
            System.out.println(cliente);
        }

        // Solicitar por teclado un número de dni de un cliente para buscarlo. En caso de que el cliente se encuentre en la lista, mostrar sus datos, caso contrario, mostrar un mensaje que informe dicha situación.
        Scanner scanner = new Scanner(System.in);
        System.out.println(" \n Por favor ingrese el DNI del cliente para buscar:");
        int dniBuscar = scanner.nextInt();
        boolean encontrado = false;
        for (Cliente cliente : clientes) {
            if (cliente.getDni() == dniBuscar) {
                System.out.println(cliente);
                encontrado = true;
            }
        }
        if (!encontrado)  System.out.println("Cliente no encontrado.");

    }
}
