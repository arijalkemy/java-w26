package org.main;

import org.entities.Cliente;
import org.entities.Localizador;
import org.entities.Reserva;
import org.respositorio.ClienteRepositorio;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ClienteRepositorio repositorioCliente = new ClienteRepositorio();
        Cliente cliente = repositorioCliente.crearCliente(new Cliente("123456789","Pepito", "Perez"));
        Localizador localizador = new Localizador(cliente,10000,1,0,1,"Avion");
        cliente.agregarLocalizador(localizador);
        System.out.println(cliente.toString());
        Localizador localizadorUno = new Localizador(cliente,12000,2,3,2,"Avion");
        cliente.agregarLocalizador(localizadorUno);
        System.out.println("\n");
        System.out.println(cliente.toString());
        Localizador localizadorDos = new Localizador(cliente,20000,1,3,0,"Avion");
        cliente.agregarLocalizador(localizadorDos);
        System.out.println(cliente.toString());
    }
}
