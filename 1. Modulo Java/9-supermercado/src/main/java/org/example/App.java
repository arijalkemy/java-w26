package org.example;

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
        /* Parte I - se necesita:
        - Crear el modelo de clases clases que conforman, una factura, los cuales son: Cliente, Item, Factura.
        - Crear 3 clientes y guardarlos en una collection.
        - Recorrer la collection de clientes y mostrar por pantalla los datos de cada uno de ellos.
        - Eliminar uno de los clientes de la lista y volver a consultar e imprimir todos los clientes restantes.
        - Solicitar por teclado un número de dni de un cliente para buscarlo. En caso de que el cliente se encuentre en la lista, mostrar sus datos, caso contrario, mostrar un mensaje que informe dicha situación.
        */

        Scanner entrada = new Scanner(System.in);
        Cliente primerCliente = new Cliente("Camila", "Beczkowski", "39459678");
        Cliente segundoCliente = new Cliente("Lucas", "Rodriguez", "28998309");
        Cliente tercerCliente = new Cliente("Juan", "Kon", "42098143");

        Set<Cliente> listaClientes = new HashSet();
        listaClientes.add(primerCliente);
        listaClientes.add(segundoCliente);
        listaClientes.add(tercerCliente);

        Supermercado supermercadoParte1 = new Supermercado(listaClientes);

        System.out.println("------ Lista de clientes inicial: -------");
        mostrarLista(supermercadoParte1.getListaClientes());

        System.out.println("Ingrese el DNI del cliente que quiere eliminar:");
        String dniRemover = entrada.next();
        supermercadoParte1.eliminarClienteSeleccionado(dniRemover);
        mostrarLista(supermercadoParte1.getListaClientes());

        System.out.println("Ingrese el DNI del cliente que quiere seleccionar:");
        String dniCliente = entrada.next();
        Cliente clienteMostrar = supermercadoParte1.mostrarCliente(dniCliente);

        if (clienteMostrar != null) {
            System.out.println("El cliente seleccionado es: " + clienteMostrar);
        } else {
            System.out.println("No existe un cliente con ese DNI en la lista actual");
        }

        /*
        Parte II:
        - Crear una nueva factura.
        - Antes de querer agregar una factura a una collection de facturas tener en cuenta que:
        - Será necesario validar si el cliente asociado a la factura se encuentra registrado en la collection de clientes. En caso de que no, el mismo deberá ser creado.
        - Será necesario crear una lista de items y asociarla a la factura creada.
        - El campo total de la factura es un campo calculado, por lo cual,
          para poder asignar este valor deberemos recorrer la lista de items y realizar las operaciones matemáticas necesarias para obtener el total.
        */

        List<Factura> listaFacturas = new ArrayList();
        List<Item> items = new ArrayList();
        Item item1 = new Item("11223", "Fideos", 3, 1000);
        Item item2 = new Item("11224", "Carne", 2, 2000);

        items.add(item1);
        items.add(item2);

        Supermercado supermercadoParte2 = new Supermercado(listaClientes, listaFacturas);
        Factura facturaAgregar = new Factura(new Cliente("Sol", "Dias", "11223444"), items);
        supermercadoParte2.agregarFactura(facturaAgregar);

        mostrarLista(supermercadoParte2.getListaClientes());

        /* Bonus:
        - Con la finalidad de optimizar el código, se requiere la creación de una interfaz “CRUD” que sea capaz de contener, mediante genéricos,
          todos los métodos necesarios para realizar altas, bajas, modificaciones y consultas.
        - Crear o utilizar las correspondientes clases que sean capaz de implementar los métodos de la interfaz creada en el punto anterior.
        - Modificar el método main para que, en lugar de realizar todo el código de manera secuencial, se pueda modularizar mediante el llamado de métodos.
         */


    }

    public static void mostrarLista(Set<Cliente> lista) {
        lista.forEach(System.out::println);
    }

}
