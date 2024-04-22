package org.example;

import org.example.model.Cliente;
import org.example.model.Factura;
import org.example.model.Producto;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static List<Cliente> clientes;
    private static List<Factura> facturas = new ArrayList<>();
    private static List<Producto> productos;

    public static void main(String[] args) {
        poblarClientes();
        poblarProductos();
        int opcion;
        do {
            mostrarMenu();
            opcion = leerOpcion();
            switch (opcion) {
                case 1:
                    clientes.forEach(System.out::println);
                    break;
                case 2:
                    eliminarCliente();
                    break;
                case 3:
                    Cliente c = clientePorDNI();
                    if (c == null) {
                        System.out.println("Cliente no econtrado");
                    } else {
                        System.out.println(c);
                    }
                    break;
                case 4:
                    crearFactura();
                    break;
                case 5:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, seleccione una opción válida.");
            }
        } while (opcion != 5);
    }

    private static void poblarClientes() {
        clientes = new ArrayList<>(List.of(
        new Cliente("Juan", "Perez", "123456A"),
        new Cliente("Maria", "Gomez", "876543B"),
        new Cliente("Pedro", "Martinez", "456789C"),
        new Cliente("Laura", "Lopez", "901234D"),
        new Cliente("Carlos", "Sanchez", "345678E"),
        new Cliente("Ana", "Rodriguez", "678901F")));
    }

    private static void mostrarMenu(){
        System.out.println(" -------- Menú -------- ");
        System.out.println("1. Mostrar todos los clientes");
        System.out.println("2. Eliminar un cliente");
        System.out.println("3. Buscar cliente por DNI");
        System.out.println("4. Crear factura");
        System.out.println("5. Salir");
        System.out.print("Seleccione una opción: ");
    }

    private static int leerOpcion() {
        Scanner scanner = new Scanner(System.in);
        try {
            return scanner.nextInt();
        } catch (Exception e) {
            return -1;
        }
    }

    private static void eliminarCliente() {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Escriba el DNI del cliente a eliminar: ");
            String dni = scanner.nextLine();
            clientes.removeIf(cliente -> cliente.getDni().equals(dni));
            System.out.println("Cliente eliminado.");
        } catch (Exception e) {
            System.out.println("Se produjo un error al eliminar el cliente: " + e.getMessage());
        }
    }

    private static Cliente clientePorDNI() {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Escriba el DNI del cliente a buscar: ");
            String dni = scanner.nextLine();
            if (clientes.stream().anyMatch(cliente -> cliente.getDni().equals(dni)))
                return clientes.stream().filter(cliente -> cliente.getDni().equals(dni)).findFirst().get();
            else return null;
        } catch (Exception e) {
            System.out.println("Valor incorrecto");
        }
        return null;
    }

    private static void poblarProductos() {
        productos = List.of(
        new Producto(1, "Arroz", 50, 4500.0),
        new Producto(2, "Frijoles", 30, 4000.0),
        new Producto(3, "Pasta", 40, 3500.0),
        new Producto(4, "Leche", 20, 2500.0),
        new Producto(5, "Huevos", 60, 7000.0),
        new Producto(6, "Pan", 35, 2000.0),
        new Producto(7, "Aceite", 25, 6000.0),
        new Producto(8, "Azúcar", 45, 3000.0),
        new Producto(9, "Café", 15, 8000.0),
        new Producto(10, "Atún", 10, 5500.0));

    }

    private static void crearCliente() {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Ingrese el nombre del cliente:");
            String nombre = scanner.nextLine();

            System.out.println("Ingrese el apellido del cliente:");
            String apellido = scanner.nextLine();

            System.out.println("Ingrese el DNI del cliente:");
            String dni = scanner.nextLine();

            clientes.add(new Cliente(nombre, apellido, dni));
            System.out.println("Cliente creado.");
        } catch (Exception e) {
            System.out.println("Se produjo un error al crear el cliente: " + e.getMessage());
        }
    }

    private static void crearFactura() {
        Factura factura = new Factura();
        Cliente c = clientePorDNI();
        if (c == null) {
            crearCliente();
            factura.setCliente(clientes.get(clientes.size()-1));
        }else {
            factura.setCliente(c);
        }

        factura.setProductos(seleccionProductos());
        facturas.add(factura);
        System.out.println(factura);
    }

    private static List<Producto> seleccionProductos() {
        List<Producto> productosObtenidos = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Para agregar los productos escriba la lista de los ids separado por comas");
            System.out.println("Ejemplo: 1,2,3,4");
            productos.forEach(System.out::println);
            System.out.print("Seleccione los productos producto: ");

            String[] numerosComoCadenas =  scanner.nextLine().split(",");

            for (String numeroComoCadena : numerosComoCadenas) {
                try {
                    int id = Integer.parseInt(numeroComoCadena.trim());
                    if(productos.stream().anyMatch(producto -> producto.getCodigo() == id)){
                     productosObtenidos.add(productos.stream().filter(producto -> producto.getCodigo() == id)
                             .findFirst().get());
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Error: " + numeroComoCadena + " no es un número entero válido.");
                }
            }
        }catch (Exception e){
            System.out.println("Se produjo un error al seleccionar el producto: " + e.getMessage());
        }

        return productosObtenidos;
    }
}