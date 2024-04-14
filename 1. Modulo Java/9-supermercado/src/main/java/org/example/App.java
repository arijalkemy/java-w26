package org.example;

import org.example.bonus.RepositorioCliente;
import org.example.bonus.RepositorioFactura;
import org.example.bonus.RepositorioItem;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        // Parte I

        Scanner entrada = new Scanner(System.in);
        RepositorioCliente repoCliente = new RepositorioCliente();
        RepositorioFactura repoFactura = new RepositorioFactura();
        RepositorioItem repoItem = new RepositorioItem();

        Cliente primerCliente = new Cliente("Camila", "Beczkowski", "39459678");
        Cliente segundoCliente = new Cliente("Lucas", "Rodriguez", "28998309");
        Cliente tercerCliente = new Cliente("Juan", "Kon", "42098143");

        repoCliente.alta(primerCliente);
        repoCliente.alta(segundoCliente);
        repoCliente.alta(tercerCliente);

        Supermercado supermercadoParte1 = new Supermercado(repoCliente, repoFactura);

        System.out.println("------ Lista de clientes inicial: -------");
        supermercadoParte1.mostrarClientes();

        System.out.println("Ingrese el DNI del cliente que quiere eliminar:");
        String dniRemover = entrada.next();
        supermercadoParte1.eliminarClienteSeleccionado(dniRemover);
        supermercadoParte1.mostrarClientes();

        System.out.println("Ingrese el DNI del cliente que quiere seleccionar:");
        String dniCliente = entrada.next();
        Cliente clienteMostrar = supermercadoParte1.mostrarCliente(dniCliente);

        if (clienteMostrar != null) {
            System.out.println("El cliente seleccionado es: " + clienteMostrar);
        } else {
            System.out.println("No existe un cliente con ese DNI en la lista actual");
        }

        // Parte II:

        System.out.println("------ Agregando items: -------");
        Item item1 = new Item("11223", "Fideos", 3, 1000);
        Item item2 = new Item("11224", "Carne", 2, 2000);

        repoItem.alta(item1);
        repoItem.alta(item2);

        Supermercado supermercadoParte2 = new Supermercado(repoCliente, repoFactura);
        Factura facturaAgregar = new Factura("02",new Cliente("Sol", "Dias", "11223444"), repoItem.traerTodos());
        supermercadoParte2.agregarFactura(facturaAgregar);

        System.out.println("------ Lista de clientes actual: -------");
        supermercadoParte2.mostrarClientes();

        System.out.println("------ Lista de facturas: -------");
        repoFactura.mostrarLista();

        System.out.println("------ Lista de items: -------");
        repoItem.mostrarLista();

    }

}
