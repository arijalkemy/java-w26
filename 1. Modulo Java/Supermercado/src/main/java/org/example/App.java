package org.example;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        // PARTE 0- Crear una lista de items
        ArrayList<Item> listaItems = new ArrayList<Item>();
        listaItems.add(new Item("Lapiz", 2, 10));
        listaItems.add(new Item("Cuaderno", 1, 50));
        listaItems.add(new Item("Goma", 3, 5));

        // PARTE 1- Crear una lista de clientes
        ArrayList<Cliente> listaClientes = new ArrayList<Cliente>();
        listaClientes.add(new Cliente("Juan", "Perez", 12345678));
        listaClientes.add(new Cliente("Maria", "Gomez", 87654321));
        listaClientes.add(new Cliente("Carlos", "Lopez", 45678912));

        //Imprime en pantalla la informacion de los clientes, nombre, apellido y dni
        listaClientes.stream().forEach(c->System.out.println(c.getNombre()+" "+c.getApellido()+" "+c.getDni()));
        elliminarCliente("Juan", listaClientes);
        listaClientes.stream().forEach(c->System.out.println(c.getNombre()+" "+c.getApellido()+" "+c.getDni()));

        //Solicitud de dni de un cliente mediante consola
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el dni del cliente a buscar");
        int dni = scanner.nextInt();
        System.out.println(dni);
        Cliente cliente = buscarCliente(dni, listaClientes);
        if(cliente!=null){
            System.out.println("Cliente encontrado: " + cliente.getNombre() + " " + cliente.getApellido());
        } else {
            System.out.println("Cliente no encontrado");
        }

        // PARTE 2- Crear una nueva factura
        System.out.println("Creando factura");
        System.out.println("Ingrese el dni del cliente");
        int dniFactura = scanner.nextInt();
        Cliente clienteFactura = buscarCliente(dniFactura, listaClientes);
        if(clienteFactura!=null){
            System.out.println("Cliente encontrado: " + clienteFactura.getNombre() + " " + clienteFactura.getApellido());
            // Creacion de items aleatorios
            ArrayList<Item> itemsFactura = new ArrayList<Item>();
            itemsFactura.add(new Item("Lapiz", 2, 10));
            itemsFactura.add(new Item("Cuaderno", 1, 50));
            itemsFactura.add(new Item("Goma", 3, 5));
            Factura factura = new Factura(clienteFactura, itemsFactura.stream().toList());
            System.out.println("Factura creada con la siguiente informacion: " + factura.toString());
        } else {
            System.out.println("Cliente no encontrado");
        }

        //crearFactura(12345678, listaItems, listaClientes);

    }

    private static Cliente buscarCliente(int dni, ArrayList<Cliente> listaClientes) {
        return listaClientes.stream().filter(c->c.getDni()==dni).findFirst().orElse(null);
    }

    public static void elliminarCliente(String nombre, ArrayList<Cliente> listaClientes){
        listaClientes.removeIf(c->c.getNombre().equals(nombre));
    }

    public static void crearFactura(int dni, ArrayList<Item> items, ArrayList<Cliente> listaClientes){
        Cliente cliente = buscarCliente(dni, listaClientes);
        if(cliente!=null){
            Factura factura = new Factura(cliente, items);
        } else {
            System.out.println("Cliente no encontrado");
        }
    }
}
