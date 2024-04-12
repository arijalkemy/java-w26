package org.example;

import java.util.List;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Scanner userInput = new Scanner(System.in);

        CashRegister cashRegister = new CashRegister();
        printClients(cashRegister.getClientList());
        System.out.println("Borrar usuario 81928342");
        cashRegister.deleteClientByDni(81928342);
        printClients(cashRegister.getClientList());

        System.out.println("Ingresa el dni para buscar al usuario:");
        long userDni = userInput.nextLong();
        Client foundClient = cashRegister.getClientByDni(userDni);
        if (foundClient == null) {
            System.out.println("Ese usuario no existe");
        } else {
            printSimpleClient(foundClient);
        }

        System.out.println("==== Crear nueva factura ====");
        System.out.println("Ingresa el dni del usuario para la factura:");
        long userDniInv = userInput.nextLong();
        Client invoiceClient = cashRegister.getOrCreateClientByDni(userDniInv);
        cashRegister.createInvoice(invoiceClient);

        /*
         * - Con la finalidad de optimizar el código, se requiere la creación de una interfaz “CRUD”
         *   que sea capaz de contener, mediante genéricos, todos los métodos necesarios para realizar altas,
         *   bajas, modificaciones y consultas.
         * - Crear o utilizar las correspondientes clases que sean capaz de implementar los métodos de la
         *   interfaz creada en el punto anterior.
         * - Modificar el método main para que, en lugar de realizar todo el codigo de manera secuencial,
         *   se pueda modularizar mediante el llamado de métodos.
         */
    }

    public static void printSimpleClient(Client client) {
        System.out.println("DNI: "+client.getDni()+" | Nombre: "+client.getFullName());
    }

    public static void printClients(List<Client> clients) {
        for(Client client : clients){
            printSimpleClient(client);
        }
    }
}
