package meli.bootcamp;

import meli.bootcamp.entidades.Cliente;
import meli.bootcamp.entidades.Factura;
import meli.bootcamp.entidades.Item;
import meli.bootcamp.entidades.Supermercado;

public class Main {

    public static void main(String[] args) {

        Supermercado supermercado = new Supermercado();
        Cliente cliente = new Cliente(11223344L,"Pedro", "Gonzales");
        supermercado.agregarClientes( cliente,new Cliente(22334455L,"Juana", "Dominguez"), new Cliente(44332211L,"Maria", "Gimenez"));

        supermercado.mostrarClientes();

        System.out.println("---------------------------");

        supermercado.buscarClientePorId(22334455L);

        System.out.println("---------------------------");

        supermercado.buscarClientePorId(1L);

        supermercado.eliminarCliente(cliente);
        supermercado.mostrarClientes();

        Factura factura = new Factura( new Cliente(33445566L,"Juan", "Ramirez") );

        factura.agregarItem( new Item("Manzana", 100.00) );
        factura.agregarItem( new Item("Banana", 150.00) );
        factura.agregarItem( new Item("Naranja", 35.00) );

        System.out.println("---------------------------");

        supermercado.agregarFacturas(factura);
        supermercado.mostrarFacturas();

        System.out.println("---------------------------");
        supermercado.mostrarClientes();
    }

}