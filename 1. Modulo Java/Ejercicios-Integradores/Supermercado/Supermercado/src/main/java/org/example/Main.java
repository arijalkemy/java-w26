package org.example;

import java.lang.ref.Cleaner;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        // Sprint 1
        // Cargar lista de clientes
        List<Cliente> clientes = new ArrayList<>(Arrays.asList(
                new Cliente("dni-1", "Luis", "Zapata"),
                new Cliente("dni-2", "Paco", "Baeza"),
                new Cliente("dni-3", "Maria", "Jimenez")
        ));

        // Imprimir informacion de clientes
        clientes.stream().forEach(cliente ->
                System.out.println(cliente.toString())
        );

        // Buscar cliente por DNI
        solicitarDni(clientes);

        // Sprint 2
        // Cargar Facturas de personas
        List<Factura> facturas = new ArrayList<>();

        // Lista de productos
        List<Producto> listA = new ArrayList<>(Arrays.asList(
                new Producto(UUID.randomUUID(), "Noodles", 12, 20.0d),
                new Producto(UUID.randomUUID(), "Fresas", 2, 59.0d),
                new Producto(UUID.randomUUID(), "Queso", 1, 30.0d)
        ));

        Factura factura = Caja.crearFactura(clientes.get(1), listA, clientes);
        System.out.println("Factura" + factura.getCliente().getNombre() + " - Costo: " + Caja.calcularCosto(factura));

    }

    public static void solicitarDni(List<Cliente> clientes){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Conoca un DNI a buscar");
        String dniABuscar = scanner.nextLine().trim();

        Optional<Cliente> clienteBuscado = clientes.stream().filter(cliente -> cliente.getDni().equals(dniABuscar)).findFirst();
        if(clienteBuscado.isPresent()){
            System.out.println(clienteBuscado.get().toString());
        }else{
            System.out.println("No se localizo al cliente buscado");
        }
    }
}