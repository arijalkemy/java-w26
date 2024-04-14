package org.example;

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

        SuperMercado superMercado = new SuperMercado();

        Cliente cliente1 = new Cliente(45455518,"Agustin","Smith");
        Cliente cliente2 = new Cliente(12345678, "Laura", "González");
        Cliente cliente3 = new Cliente(431235518, "Mateo", "Segundo");

        superMercado.agregarCliente(cliente1);
        superMercado.agregarCliente(cliente2);
        superMercado.agregarCliente(cliente3);


        superMercado.imprimirClientes();
        superMercado.eliminarCliente("Agustin");
        System.out.println("Con cliente eliminado");
        superMercado.imprimirClientes();
        superMercado.buscarCliente();

        Producto producto1 = new Producto("1","Coca Cola",2,1250.00);
        Producto producto2 = new Producto("2","Manteca",1,700.00);
        Producto producto3 = new Producto("3","Papas fritas",3,400.00);

        List<Producto> productoList = new ArrayList<>();
        productoList.add(producto1);
        productoList.add(producto2);
        productoList.add(producto3);

        Factura factura = new Factura(cliente2, productoList, superMercado.calcularTotalListaDeCompras(productoList));
        Factura factura1 = new Factura(cliente1, productoList, superMercado.calcularTotalListaDeCompras(productoList));

        superMercado.agregarFactura(factura);
        superMercado.imprimirFactura();

        superMercado.agregarFactura(factura1);



    }
}
