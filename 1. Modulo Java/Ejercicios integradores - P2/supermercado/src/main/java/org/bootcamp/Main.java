package org.bootcamp;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        //Crear 3 clientes y guardarlos en una collection
        List<Cliente> clientes = new ArrayList<>(List.of(
                new Cliente("1234", "Juan", "Plazas"),
                new Cliente("5678", "Luz", "Gonzalez"),
                new Cliente("9101", "Pedro", "Sanchez")
        ));
        //recorrer la collection de clientes y mostrar por pantalla los datos de cada uno de ellos
        for(Cliente cliente: clientes) {
            System.out.println(cliente);
        }
        //eliminar uno e los clientes de la lista y volver a consultar e imprimir los clientes restantes
        clientes.remove(1);
        for(Cliente cliente: clientes) {
            System.out.println(cliente);
        }

        //buscar cliente por dni
        System.out.println("Ingrese el dni del cliente a buscar: ");
        String dni = scanner.nextLine();
        boolean encontrado = false;
        for(Cliente cliente: clientes) {
            if(cliente.getDni().equals(dni)) {
                System.out.println(cliente);
                encontrado = true;
            }
        }
        if (!encontrado) {
            System.out.println("Cliente no encontrado");
        }

        //Crear una nueva factura

        Factura factura = new Factura(new Cliente("1234", "Juan", "Plazas"),
                new ArrayList<>(List.of(new Producto("1","producto 1",2,500),
                        new Producto("2","producto 2", 1,1250))));

        //Verificar existencia del cliente en la lista de clientes si existe se añade al repositorio de facturas

        if(clientes.stream().anyMatch(cliente -> cliente.getDni().equals(factura.getCliente().getDni()))) {
            System.out.println("Cliente encontrado");
        } else {
            System.out.println("Cliente no encontrado");
            clientes.add(factura.getCliente());
        }

        List<Factura> facturas = new ArrayList<>();

        facturas.add(factura);



    }
}