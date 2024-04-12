package org.example;

import org.example.Repository.ClienteImp;

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
        Cliente clienteUno = new Cliente(39222145,"Matias","Palomo");
        Cliente clienteDos = new Cliente(30123442,"Gonzalo","Gomez");
        Cliente clienteTres = new Cliente(3012345,"Ivan","Caro");
        Cliente clienteCuatro = new Cliente(30212345,"Carlos","Pepe");


        /*List<Cliente> clienteList = new ArrayList<Cliente>();
        clienteList.add(clienteUno);
        clienteList.add(clienteDos);
        clienteList.add(clienteTres);*/


        ClienteImp clienteImp = new ClienteImp();

        clienteImp.alta(clienteUno);
        clienteImp.alta(clienteDos);
        clienteImp.alta(clienteTres);

        List<Item> listaItems = new ArrayList<>();
        String[] nombres = {"Heladera", "Celular", "Televisor", "Radio", "Lavarropa", "Auriculares", "Teclado", "Mouse", "Monitor"};

        // Agregar 10 ítems a la lista
        for (int i = 1; i <= nombres.length; i++) {
            Item item = new Item(i, nombres[i-1], i * 100); // Ejemplo de costo unitario: i * 100
            listaItems.add(item);
        }

        List<Factura> listaFacturas = new ArrayList<>();
        Factura facturaUno = new Factura(clienteTres,listaItems);



       /* if(facturaUno.existeClienteLista(clienteList,facturaUno.getCliente()))
        {
            System.out.println("El cliente existe en la lista, " + facturaUno.getCliente().imprimir() );
            listaFacturas.add(facturaUno);
        }
        else
        {
            System.out.println("No existe el cliente en la lista");
        }


        */
        clienteImp.mostrarPantalla();

    }
}
