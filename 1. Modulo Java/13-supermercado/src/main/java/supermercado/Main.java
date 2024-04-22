package supermercado;

import supermercado.classes.Cliente;
import supermercado.classes.Factura;
import supermercado.classes.Item;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
     public static List<Item> ingresarListaItems() {
        List<Item> items = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese los datos de los items. Escriba 'fin' para terminar.");

        while (true) {
            System.out.print("Código del item: ");
            String codigo = scanner.nextLine();
            if (codigo.equals("fin")) {
                break;
            }
            System.out.print("Nombre del item: ");
            String nombre = scanner.nextLine();
            System.out.print("Cantidad comprada: ");
            int cantidadComprada = Integer.parseInt(scanner.nextLine());
            System.out.print("Costo unitario: ");
            double costoUnitario = Double.parseDouble(scanner.nextLine());

            Item item = new Item(codigo, nombre, cantidadComprada, costoUnitario);
            items.add(item);
        }

        return items;
    }

    public static void main(String[] args) {
        List<Cliente> clientes = new ArrayList<Cliente>();
        Scanner scanner = new Scanner(System.in);

        // Crear 3 clientes y guardarlos en una collection.
        clientes.add(new Cliente("40111222", "Jose", "Gomez"));
        clientes.add(new Cliente("41333222", "Juan", "Cito"));
        clientes.add(new Cliente("42111444", "Pep", "Guardiola"));

        System.out.println("Clientes:");
        clientes.stream().forEach(System.out::println);

        // Eliminar uno de los clientes de la lista y volver a consultar e imprimir todos los clientes restantes.
        System.out.println("Indique el DNI de un cliente a remover");
        String dniARemover = scanner.nextLine();
        clientes = clientes.stream().filter(c -> !c.getDni().equals(dniARemover)).collect(Collectors.toList());
        System.out.println("Nueva lista de clientes:");
        clientes.stream().forEach(System.out::println);

        System.out.print("Ingresar DNI para buscar un cliente: ");
        String dniABuscar = scanner.nextLine();

        Optional<Cliente> clienteAEncontrar = clientes.stream().filter(cliente -> cliente.getDni().equals(dniABuscar)).findFirst();

        if (clienteAEncontrar.isPresent()) {
            System.out.println("Cliente encontrado: " + clienteAEncontrar.get());
        } else {
            System.out.println("Cliente con '" + dniABuscar + "' no encontrado.");
        }

        List<Factura> facturas = new ArrayList<>();

        System.out.println("Ingrese un DNI para crear factura: ");
        String dniCrearFactura = scanner.nextLine();

        clienteAEncontrar = clientes.stream().filter(cliente -> cliente.getDni().equals(dniCrearFactura)).findFirst();

        if (clienteAEncontrar.isPresent()) {
            System.out.println("Cliente encontrado: " + clienteAEncontrar.get());
            List<Item> items = ingresarListaItems();
            System.out.println("Creando factura...");
            Factura factura = new Factura(clienteAEncontrar.get());
            System.out.println("Agregandole lista...");
            factura.setItems(items);
            System.out.println("Factura creada, datos: " + factura);

        } else {
            System.out.println("Cliente con '" + dniABuscar + "' no encontrado.");
        }
    }
}
