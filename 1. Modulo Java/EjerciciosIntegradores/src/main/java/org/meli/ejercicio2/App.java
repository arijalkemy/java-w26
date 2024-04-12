package org.meli.ejercicio2;
import org.meli.ejercicio2.clases.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Cliente cliente = new Cliente(12345678, "Juan", "Perez");
        Factura factura = new Factura(cliente);
        factura.agregarProducto(new Producto(1, "Arroz ROA 25kg", 100.0, 2));
        factura.agregarProducto(new Producto(2, "Fideos Marolio 500g", 50.0, 3));
        factura.agregarProducto(new Producto(3, "Aceite Cocinero 1L", 30.0, 1));
        factura.imprimirFactura();
        List<Cliente> clienteList = new ArrayList<>();
        clienteList.add(new Cliente(12345678, "Juan", "Perez"));
        clienteList.add(new Cliente(87654321, "Maria", "Lopez"));
        clienteList.add(new Cliente(11223344, "Pedro", "Gomez"));

        for (Cliente c : clienteList) {
            System.out.println(c.toString()+"\n");
        }

        clienteList.remove(1);

        System.out.println("\n\nLista de clientes sin Maria Lopez");

        for (Cliente c : clienteList) {
            System.out.println(c.toString()+"\n");
        }
        Scanner teclado = new Scanner(System.in);
        Integer dni = teclado.nextInt();
        List<Cliente> listaFiltrada = clienteList.stream().filter(c -> c.getDni().equals(dni)).toList();
        if (listaFiltrada.size() > 0) {
            System.out.println("Cliente encontrado: "+listaFiltrada.get(0).toString());
        } else {
            System.out.println("Cliente no encontrado");
        }

    }
}
