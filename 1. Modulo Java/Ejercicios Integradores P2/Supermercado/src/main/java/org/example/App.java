package org.example;

import java.util.Scanner;

public class App 
{
    public static void main( String[] args )
    {

        Supermercado supermercado = new Supermercado();

        supermercado.agregar(new Cliente(40895600, "Lautaro", "Oleastro"));
        supermercado.agregar(new Cliente(41895600, "Segundo", "Cliente"));
        supermercado.agregar(new Cliente(42895600, "Tercer", "Cliente"));

        Cliente clienteABorrar = new Cliente(44895600, "Cliente", "Para Borrar");

        supermercado.cargarFactura();

    }
}
