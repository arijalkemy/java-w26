package org.example.ejercicio3;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        // Parte I - Punto 2: Crear 3 clientes y guardarlos en una collection.
        List<Cliente> clientes = new ArrayList<>();
        clientes.add(new Cliente("12345678", "Pepito", "Vélez"));
        clientes.add(new Cliente("11111111", "Armando Esteban", "Quito"));
        clientes.add(new Cliente("88888888", "Marcos", "Galarza"));

        // Parte I - Punto 3
        // Recorrer la collection de clientes y mostrar por pantalla los datos de cada uno de ellos.
        System.out.println("\nClientes:");
        clientes.forEach(System.out::println);

        // Parte I - Punto 4
        // Eliminar uno de los clientes de la lista y volver a consultar e imprimir todos los clientes restantes.
        clientes.remove(1);
        System.out.println("\nClientes (después de eliminar uno):");
        clientes.forEach(System.out::println);

        // Parte I - Punto 5
        // Solicitar por teclado un número de dni de un cliente para buscarlo.
        // En caso de que el cliente se encuentre en la lista, mostrar sus datos,
        // caso contrario, mostrar un mensaje que informe dicha situación.
        Scanner scanner = new Scanner(System.in);
        String entrada;

        while (true) {
            System.out.println("\nIngrese DNI de Cliente para buscarlo, o Enter para continuar con el resto del programa:");
            entrada = scanner.nextLine();

            if (entrada.isBlank())
                break;

            String entradaAux = entrada;

            Optional<Cliente> clienteOpt = clientes.stream()
                .filter(cliente -> cliente.getDni().equals(entradaAux))
                .findFirst();

            if (clienteOpt.isPresent()){
                System.out.println("Se encontró el siguiente cliente:");
                System.out.println(clienteOpt.get());
            }
            else {
                System.out.println("No se encontró un cliente con ese DNI.");
            }
        }

        System.out.println("Entrada vacía, se continúa la ejecución...");


        /* **********************************************
                    Parte II
        ************************************************* */

        Supermercado supermercado = new Supermercado(clientes);

        // Crear una Factura para un Cliente existente
        Factura factura1 = supermercado.agregarFactura(
            clientes.get(1),
            List.of(
                new Item("Cafe", 2, 1500),
                new Item("Leche", 1, 800),
                new Item("Huevos", 12, 2000)
            )
        );
        System.out.println("\nNueva Factura agregada:");
        System.out.println(factura1);

        // Crear una Factura para un nuevo Cliente
        Factura factura2 = supermercado.agregarFactura(
            new Cliente("87654321", "Josecito", "Benavidez"),
            List.of(
                new Item("Clavos", 150, 4.50)
            )
        );
        System.out.println("\nNueva Factura agregada:");
        System.out.println(factura2);

        // Verificar que el Supermercado tenga 4 Clientes registrados en total
        System.out.println("\nClientes registrados:");
        supermercado.getClientes().forEach(System.out::println);
    }
}
