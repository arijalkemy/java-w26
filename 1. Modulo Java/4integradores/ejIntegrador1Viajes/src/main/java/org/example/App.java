package org.example;

import org.example.model.Client;
import org.example.model.Ticket;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Client cliente = new Client();

        //Creation of demo ticket
        Ticket ticket1 = new Ticket();

        ticket1.setFood(1);
        ticket1.setHotel(2);
        ticket1.setTransport(0);
        ticket1.setPlaneTickets(1);

        cliente.appendTicket(ticket1);

        System.out.println(cliente.allTickets());
    }
}
