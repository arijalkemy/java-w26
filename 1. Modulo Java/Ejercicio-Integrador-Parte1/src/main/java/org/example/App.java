package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println("\n------ PARTE 1 -------");

        //Instancio clientes
        Cliente clienteUno = new Cliente("111", "NombreUno", "ApellidoUno");
        Cliente clienteDos = new Cliente("222", "NombreDos", "ApellidoDos");
        Cliente clienteTres = new Cliente("333", "NombreTres", "ApellidoTres");

        //Instancio supermercado
        Supermercado supermercado = new Supermercado();

        //Agrego clientes al supermercado
        supermercado.agregarCliente(clienteUno);
        supermercado.agregarCliente(clienteDos);

        //Consulto listado de clientes del supermercado y los muestra en pantalla
        supermercado.listadoDeClientes();

        //Elimino al cliente dos de la lista del supermercado
        supermercado.removerCliente(clienteDos);

        System.out.println("\n------ Elimino a un cliente -------");
        //Muesto el listado del supermercado luego de eliminar a un cliente
        supermercado.listadoDeClientes();

        System.out.println("\n------ Busco un cliente por su DNI y lo muestro -------");
        Optional<Cliente> clienteEncontrado = supermercado.buscarClientePorDni("111");

        if(clienteEncontrado.isPresent()){
            System.out.println("Cliente encontrado: "+ clienteEncontrado.toString());
        } else {
            System.out.println("No se encontro un cliente con ese numero de DNI");
        }

        System.out.println("\n------ PARTE 2 -------");
        List<Item> items = new ArrayList<>();
        Item itemUno = new Item("1", "ItemUno", 1, 100);
        Item itemDos = new Item("2", "ItemDos", 2, 200);
        items.add(itemUno);
        items.add(itemDos);

        //Creo una facutra
        supermercado.comprar(clienteTres, items);

        //Muestro el listado de facturas del supermercado
        System.out.println("\n------ Listado de facturas -------");
        for (Factura factura: supermercado.facturas){
            System.out.println("Cliente: " + factura.getCliente().getNombre()
                + "\nItems: " + factura.getItems()
                + "\nTotal: " + factura.getTotalCompra()
                + "\n----------------");
        }

    }
}
