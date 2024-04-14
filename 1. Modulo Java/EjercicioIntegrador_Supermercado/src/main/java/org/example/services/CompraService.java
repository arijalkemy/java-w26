package org.example.services;

import org.example.models.Cliente;
import org.example.models.Factura;
import org.example.models.Producto;
import org.example.repositories.ClienteRepository;
import org.example.repositories.FacturaRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CompraService {

    private Scanner scanner = new Scanner(System.in);
    private ClienteRepository clienteRepository = new ClienteRepository();
    private FacturaRepository facturaRepository = new FacturaRepository();

    public void menu() {
        int opcion;
        do {
            System.out.println("Menu");
            System.out.println("1. Comprar");
            System.out.println("2. Salir");
            System.out.printf("Opción: ");
            opcion = scanner.nextInt();
            if (opcion == 1) {
                comprar();
            } else if (opcion != 2) {
                System.out.println("Opción incorrecta, vuelva a seleccionar");
            }
        } while (opcion != 2);
    }

    public void comprar() {
        List<Producto> productos = new ArrayList<>();
        int opcion, dni;
        Producto producto;
        String nombre, apellido;
        System.out.printf("Ingrese su DNI: ");
        dni = scanner.nextInt();
        System.out.printf("Ingrese su Nombre: ");
        nombre = scanner.nextLine();
        nombre = scanner.nextLine();
        System.out.printf("Ingrese su Apellido: ");
        apellido = scanner.nextLine();
        Cliente cliente = clienteRepository.create(new Cliente(dni, nombre, apellido));
        do {
            producto = seleccionProducto();
        } while (producto == null);
        productos.add(producto);
        do {
            System.out.println("¿Desea agregar otro producto?");
            System.out.println("1. Si");
            System.out.println("2. No");
            opcion = scanner.nextInt();
            if (opcion == 1) {
                do {
                    producto = seleccionProducto();
                } while (producto == null);
                productos.add(producto);
            } else if (opcion != 2) {
                System.out.println("Opcicón invalida, vuelva a intenetarlo");
            }
        } while (opcion != 2);
        Factura factura = new Factura(cliente, productos);
        System.out.println("Compra exitosa");
        System.out.println("Total: " + factura.getTotal());
        facturaRepository.create(factura);
    }

    public void primeraPrueba() {
        System.out.println("Creación de clientes y se muestran");
        Cliente cliente1 = new Cliente(1, "Cristopher", "Vargas");
        Cliente cliente2 = new Cliente(2, "Alex", "Romero");
        Cliente cliente3 = new Cliente(3, "Brayan", "Pinto");
        clienteRepository.create(cliente1);
        clienteRepository.create(cliente2);
        clienteRepository.create(cliente3);
        for (Cliente cliente : clienteRepository.read()) {
            System.out.println(cliente.toString());
        }
        System.out.println("Eliminar cliente con dni: 1");
        clienteRepository.delete(cliente1);
        for (Cliente cliente : clienteRepository.read()) {
            System.out.println(cliente.toString());
        }
        System.out.println("Ingrese un dni para buscar un cliente a quien corresponda: ");
        int dni = scanner.nextInt();
        Cliente cliente = clienteRepository.getByID(dni);
        if (cliente == null) {
            System.out.println("Usuario no encontrado");
        } else {
            System.out.println("Usuario encontrado: ");
            System.out.println(cliente.toString());
        }
    }

    public void segundaPrueba() {
        System.out.println("Inicio de segunda pruba - Creación Factura");
        Factura factura;
        Cliente cliente = new Cliente(4, "Sebastian", "Pinilla");
        //Cliente cliente = new Cliente(3, "Brayan", "Pinto");
        cliente = clienteRepository.create(cliente);
        List<Producto> productos = new ArrayList<>();
        productos.add(new Producto(1, "Tomate", 4, 400));
        productos.add(new Producto(2, "Arroz", 5, 2500));
        productos.add(new Producto(3, "Aguacate", 6, 2000));
        factura = new Factura(cliente, productos);
        System.out.println("Factura creada");
        System.out.println("Factra de : " + cliente.toString());
        System.out.println("Productos: ");
        for (Producto producto : factura.getProductos()) {
            System.out.println("\tProducto: " + producto.getCodigo() + " - " + producto.getNombre());
            System.out.println("\tCosto Unitario: " + producto.getCostoUnitario());
            System.out.println("\tCantidad: " + producto.getCantidadComprada() + "\n");
        }
        System.out.println("Total: " + factura.getTotal());
        facturaRepository.create(factura);
    }

    public Producto seleccionProducto() {
        System.out.println("Seleccione Producto");
        System.out.println("1. Tomate");
        System.out.println("2. Arroz");
        System.out.println("3. Aguacate");
        int seleccion = scanner.nextInt();
        System.out.println("Ingrese la cantidad");
        int cantidad = scanner.nextInt();
        if (seleccion == 1) {
            return new Producto(1, "Tomate", cantidad, 400);
        } else if (seleccion == 2) {
            return new Producto(2, "Arroz", cantidad, 2500);
        } else if (seleccion == 3) {
            return new Producto(3, "Aguacate", cantidad, 2000);
        } else {
            System.out.println("Opción invalida");
            return null;
        }
    }
}
