package org.example;

import org.example.entidad.Cliente;
import org.example.entidad.Factura;
import org.example.entidad.Item;
import org.example.repositorio.impl.IRepositorioCRUDImplCliente;
import org.example.repositorio.impl.IRepositorioCRUDImplFactura;

import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        IRepositorioCRUDImplCliente crudCliente = new IRepositorioCRUDImplCliente();
        IRepositorioCRUDImplFactura crudFactura = new IRepositorioCRUDImplFactura();
        SuperMercado superMercado = new SuperMercado(crudCliente, crudFactura);

        Cliente cli1 = new Cliente("agustin","juarez");
        Cliente cli2 = new Cliente("juan","guarnizo");
        Cliente cli3 = new Cliente("AMONG", "us");

        crudCliente.guardar(cli1);
        crudCliente.guardar(cli2);
        crudCliente.guardar(cli3);

        crudCliente.imprimir();
        superMercado.buscarClientePorConsola();




        Item item1= new Item(43L,2,"Coca Cola",1500.00);
        Item item2= new Item(11L,4,"Manteca",700.00);

        Item item3 = new Item(25L, 1, "Pan", 250.00);
        Item item4 = new Item(7L, 3, "Leche", 300.00);


        List<Item> items1 = new ArrayList<>();
        List<Item> items2 = new ArrayList<>();
        items1.add(item1);
        items1.add(item2);

        items2.add(item3);
        items2.add(item4);

        Factura factura1 = new Factura(items1,cli1);
        Cliente cliente4 = new Cliente("Ramiro","Lopez");
        Factura factura2 = new Factura(items2,cliente4);

        crudCliente.imprimir();
        crudFactura.imprimir();

        superMercado.realizarCompra(factura1);
        superMercado.realizarCompra(factura2);

        crudCliente.imprimir();
        crudFactura.imprimir();

    }
}
