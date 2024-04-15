package org.example;

import org.example.entidades.Cliente;
import org.example.entidades.Item;
import org.example.entidades.Localizador;
import org.example.entidades.Paquete;
import org.example.enums.ItemTipo;
import org.example.repositorios.impl.IRepositorioImplCliente;
import org.example.repositorios.impl.IRepositorioImplLocalizador;

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
        IRepositorioImplLocalizador repositorioImplLocalizador = new IRepositorioImplLocalizador();
        IRepositorioImplCliente repositorioImplCliente = new IRepositorioImplCliente();
        AgenciaDeTurismo agenciaDeTurismo = new AgenciaDeTurismo(repositorioImplCliente,repositorioImplLocalizador);


        Item item1 = new Item(ItemTipo.BOLETOS_DE_VIAJE,250.00,4);
        Item item2 = new Item(ItemTipo.COMIDA, 100.00,20);
        Item item3 = new Item(ItemTipo.TRANSPORTE, 200.00,8);
        Item item4 = new Item(ItemTipo.HOTEL, 400.00,4);

        List<Item> paqueteFull = new ArrayList<>();
        Cliente cliente1 = new Cliente("Agustin","Juarez");

        paqueteFull.add(item1);
        paqueteFull.add(item2);
        paqueteFull.add(item3);
        paqueteFull.add(item4);

        Paquete paquete1 = new Paquete(paqueteFull);
        Localizador localizador1 = new Localizador(paquete1,cliente1);




    }
}
