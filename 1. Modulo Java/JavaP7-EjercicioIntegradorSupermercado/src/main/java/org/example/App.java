package org.example;

import org.example.Collections.ClienteCollection;
import org.example.Collections.FacturaCollection;
import org.example.Collections.ItemCollection;
import org.example.Model.Cliente;
import org.example.Model.Factura;
import org.example.Model.Item;

import java.awt.color.ProfileDataException;
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

        ClienteCollection clientes = new ClienteCollection(
                new Cliente("1234567", "Cliente 1", "Apellido 1"),
                new Cliente("1234890", "Cliente 2", "Apellido 2"),
                new Cliente("1234986", "Cliente 3", "Apellido 3")
        );

        clientes.mostrar();

        /*Scanner scanner = new Scanner(System.in);
        System.out.print("Que usuario estas Buscando: ");
        String scannedData = scanner.nextLine();
        System.out.println(scannedData);
        clientes.eliminar(scannedData);

        clientes.mostrar();*/


        System.out.println("Creando una nuevos Factura");
        Item item1 = new Item(1, "Producto1", 2, 50);
        Item item2 = new Item(2, "Producto2", 3, 50);

        ItemCollection productos = new ItemCollection();

        productos.guardar(item1);
        productos.guardar(item2);

        Cliente cliente = (Cliente) clientes.buscar("1234567");
        Factura factura1 = new Factura(cliente, productos);

        FacturaCollection facturas = new FacturaCollection();

        facturas.agregaFactura(factura1, clientes);

        facturas.mostrar();

        Factura factura2 = new Factura(new Cliente("122", "dd", "ss"), productos);

        facturas.agregaFactura(factura2,clientes);

        System.out.println("El precio de la factura 2 es: $" + factura2.calculaFactura());


    }
}
