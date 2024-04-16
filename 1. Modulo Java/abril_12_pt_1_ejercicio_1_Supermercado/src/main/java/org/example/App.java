package org.example;

import com.sun.tools.javac.jvm.Items;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App 
{
    private static Scanner scanner = new Scanner(System.in);
    public static void main( String[] args )
    {

        SuperMarket superMarket = new SuperMarket();
        superMarket.addClient("Alexis", "Chavez", "COCACO");
        superMarket.addClient("Melissa", "Chavez", "COCA010406HMC");
        superMarket.addClient("Diego", "Chavez", "COCA010406HMC");
//        Factura factura = new Factura();
        // -> Print clients
        superMarket.showClients();

        // -> Remove a client
        superMarket.deleteClient("COCA010406HMCNHLA8");

        // -> Print clients again
        superMarket.showClients();

        System.out.print("Type dni to search: ");
        String dni = scanner.nextLine();

        superMarket.findClientByDni(dni);

        // -> Add items on a list

        List<Item> items = new ArrayList<>();

        items.add(new Item("1", "Item 1", 10.0, 2));
        items.add(new Item("2", "Item 2", 20.0, 3));
        items.add(new Item("3", "Item 3", 30.0, 4));
        items.add(new Item("4", "Item 4", 40.0, 5));


        // -> Create a invoice

        Factura factura = new Factura(new Client("Alexis", "Chavez", "COCACO"));
        factura.setItems(items);

        int total = factura.getTotal();
        System.out.println("Total: " + total);

    }
}
