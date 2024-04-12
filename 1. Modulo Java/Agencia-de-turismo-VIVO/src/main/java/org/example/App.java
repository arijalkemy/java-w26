package org.example;

import jdk.jfr.internal.Repository;

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
        LocalizadorRepository localizadorRepository = new LocalizadorRepository();

        Producto hotel = new Producto(TipoProducto.HOTEL, 1,100);
        Producto boleto = new Producto(TipoProducto.BOLETO, 1, 50);
        Producto transporte = new Producto(TipoProducto.TRANSPORTE, 1,20);
        Producto comida = new Producto(TipoProducto.COMIDA, 1, 10);

        Cliente cliente = new Cliente("12345678", "Juan", "Perez");

        Localizador localizador = new Localizador(cliente);
        localizador.agregarProducto(hotel);
        localizador.agregarProducto(boleto);
        localizador.agregarProducto(transporte);
        localizador.agregarProducto(comida);

        localizadorRepository.save(localizador);

        System.out.println("Cliente: " + localizador.getCliente().getNombre()
                + "\nProductos: " + localizador.listaDeProductos()
                + "\nTotal: " + localizador.getTotal());
    }
}
