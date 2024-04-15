package org.example;

import org.example.factura.Factura;
import org.example.factura.Item;
import org.example.supermercado.impl.SupermercadoImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        SupermercadoImpl supermercado = new SupermercadoImpl();

        Cliente cliente1 = new Cliente(10100100, "Juan", "Perez");
        Cliente cliente2 = new Cliente(11111111, "Roberto", "Carlos");
        Cliente cliente3 = new Cliente(12122122, "Fernando", "Gago");
        supermercado.addCliente(cliente1);
        supermercado.addCliente(cliente2);
        supermercado.addCliente(cliente3);

        supermercado.getClientes();

        // Elimino un cliente
        supermercado.deleteCliente(cliente2);

        supermercado.getClientes();

        int dniInput = leerDniPorConsola();
        Optional<Cliente> clienteEncontrado = supermercado.getCliente(dniInput);

        if (clienteEncontrado.isPresent()){
            System.out.println(clienteEncontrado);
        }

        //Parte II
        List<Item> itemList = new ArrayList<>();
        Item item1 = new Item(001, "Harina", 100, 1500.00);
        Item item2 = new Item(002, "Pepsi Black", 50, 1200.00);
        itemList.add(item2);
        itemList.add(item2);
        Factura factura = new Factura(cliente1, itemList, 1000);
        supermercado.addFacturaACliente(factura, cliente1);

        supermercado.getClientes();

        System.out.println("El total de la factura es de: " + factura.getTotal());

    }

    public static int leerDniPorConsola() {
        // Crear un objeto Scanner para leer la entrada del teclado
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese el dni a buscar: ");

        // Leer el número entero ingresado por el usuario en una sola línea
        int numero = Integer.parseInt(scanner.nextLine());

        // Imprimir el número ingresado por el usuario
        System.out.println("Ha ingresado el número: " + numero);

        // Cerrar el objeto Scanner después de su uso
        scanner.close();

        return numero;
    }
}