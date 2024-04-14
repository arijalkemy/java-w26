package org.example;

import org.example.classes.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // Parte 1
        // Creo 3 clientes y lo guardo en una collection
        List<Cliente> clientes = new ArrayList<>();
        clientes.add(new Cliente(40000000, "Matias", "Pinto"));
        clientes.add(new Cliente(39999999, "Nicolas", "Rodriguez"));
        clientes.add(new Cliente(41111111, "Brenda", "Guidi"));

        // Recorro el listado e imprimo
        for (Cliente cliente : clientes) {
            System.out.println(cliente);
        }
        System.out.println("------------------");

        // Elimino uno de los clientes y vuelvo a imprimir el resto
        clientes.remove(2);
        for (Cliente cliente : clientes) {
            System.out.println(cliente);
        }

        /*
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese un dni a buscar: ");
        String dniScanner = scanner.nextLine();
        clientes.stream()
                .filter(cliente -> cliente.getDni().equals(dniScanner))
                .findFirst()
                .ifPresentOrElse(System.out::println,
                        () -> System.out.println("No existen cliente con ese dni")
                );
        */

        // Item parte 2 --------
        // Creo supermercado y un cliente
        Supermercado supermercado = new Supermercado();
        Cliente mati = new Cliente(1111, "Matias", "Nicols");
        supermercado.crearCliente(mati);

        // Creo el carrito del supermercado
        List<Item> carrito = new ArrayList<>();
        Producto sopa = new Producto(0,"Sopa Knor", 120.75);
        Producto arroz = new Producto(0,"Arroz yamani", 50.98);
        Producto vino = new Producto(0,"Nieto Senetiner", 4000.87);
        carrito.add(new Item(sopa, 2));
        carrito.add(new Item(arroz, 1));
        carrito.add(new Item(vino, 1));

        // Creo una factura conteniendo un cliente y un carrito.
        Factura factura = new Factura(mati, carrito);
        supermercado.crearFactura(factura);

        // Creo una factura conteniendo un cliente que NO existe y un carrito.
        Factura factura2 = new Factura(new Cliente(2222, "Nicolas", "Rodriguez"), carrito);
        supermercado.crearFactura(factura2);

        System.out.println();
        System.out.println("Factura con ID 0:");
        System.out.println(supermercado.buscarFactura(0));

    }
}