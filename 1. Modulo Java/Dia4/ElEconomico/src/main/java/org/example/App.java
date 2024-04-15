package org.example;

import java.util.*;

public class App {
    public static void main(String[] args) {
        Cliente cliente1 = new Cliente(12345678, "Pepe", "Juarez");
        Cliente cliente2 = new Cliente(98765432, "Juan", "Santos");
        Cliente cliente3 = new Cliente(73856274, "Santiago", "Perez");

        List<Cliente> clientes = new ArrayList<>();
        clientes.add(cliente1);
        clientes.add(cliente2);
        clientes.add(cliente3);

        for (Cliente cliente : clientes) {
            System.out.println("Cliente: " + cliente.getNombre() + " " +
                    cliente.getApellido() + " - DNI: " + cliente.getDni());
        }

        Random random = new Random();
        clientes.remove(random.nextInt(clientes.size()));

        System.out.println("Lista actualizada:");

        for (Cliente cliente : clientes) {
            System.out.println("Cliente: " + cliente.getNombre() + " " +
                    cliente.getApellido() + " - DNI: " + cliente.getDni());
        }

        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el DNI del cliente:");
        int dniCliente = scanner.nextInt();

        Cliente clienteSeleccionado = null;
        for (Cliente cliente : clientes) {
            if (dniCliente == cliente.getDni()) {
                clienteSeleccionado = cliente;
                break;
            }
        }

        if (clienteSeleccionado == null) {
            System.out.println("Cliente no encontrado en la lista. Se creará uno nuevo.");
            System.out.println("Ingrese el nombre del nuevo cliente:");
            String nombreNuevoCliente = scanner.next();
            System.out.println("Ingrese el apellido del nuevo cliente:");
            String apellidoNuevoCliente = scanner.next();
            clienteSeleccionado = new Cliente(dniCliente, nombreNuevoCliente, apellidoNuevoCliente);
            clientes.add(clienteSeleccionado);
        }

        List<Item> itemsFactura = new ArrayList<>();
        System.out.println("Ingrese el número de ítems de la factura:");
        int numItems = scanner.nextInt();
        for (int i = 0; i < numItems; i++) {
            System.out.println("Ingrese el código del ítem:");
            int codigoItem = scanner.nextInt();
            System.out.println("Ingrese el nombre del ítem:");
            String nombreItem = scanner.next();
            System.out.println("Ingrese la cantidad comprada del ítem:");
            int cantidadItem = scanner.nextInt();
            System.out.println("Ingrese el costo unitario del ítem:");
            double costoUnitarioItem = scanner.nextDouble();
            itemsFactura.add(new Item(codigoItem, nombreItem, cantidadItem, costoUnitarioItem));
        }

        double totalFactura = 0;
        for (Item item : itemsFactura) {
            totalFactura += item.getCantidadComprada() * item.getCostoUnitario();
        }

        System.out.println("El total de la factura es: $" + totalFactura);

        // Crear una nueva factura con el cliente seleccionado y la lista de ítems
        Factura nuevaFactura = new Factura(clienteSeleccionado, totalFactura, itemsFactura);

        // Agregar la nueva factura a la colección de facturas
        List<Factura> facturas = new ArrayList<>();
        facturas.add(nuevaFactura);

        // Imprimir las facturas agregadas
        System.out.println("\nFacturas:");
        for (Factura factura : facturas) {
            if (factura != null) {
                System.out.println("Factura encontrada.");
                Cliente clienteFactura = factura.getCliente();
                if (clienteFactura != null) {
                    System.out.println("Cliente: " + clienteFactura.getNombre() + " " + clienteFactura.getApellido() +
                            " - Total: $" + factura.getTotalCompra());
                    System.out.println("Ítems:");
                    for (Item item : factura.getListaItems()) {
                        System.out.println("Código: " + item.getCodigo() + " - Nombre: " + item.getNombre() +
                                " - Cantidad: " + item.getCantidadComprada() + " - Costo Unitario: $" + item.getCostoUnitario());
                    }
                } else {
                    System.out.println("Factura sin cliente asociado.");
                }
            } else {
                System.out.println("Factura nula.");
            }
        }

    }
}

