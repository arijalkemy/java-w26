package com.example;

import java.util.ArrayList;
import java.util.List;

import com.example.model.BookingElement;
import com.example.model.Client;
import com.example.model.Reservation;
import com.example.repository.BookingElementRepository;
import com.example.repository.ClientRepository;
import com.example.repository.ReservationRepository;

public class App {
    public static void main(String[] args) {

        ClientRepository clientRepository = new ClientRepository();
        BookingElementRepository bookingElementRepository = new BookingElementRepository();
        ReservationRepository reservationRepository = new ReservationRepository();

        ShowData showData = new ShowData();

        /*
         * CREANDO EL PRIMER LOCALIZADOR
         */

        // Clientes
        Client client1 = new Client("Salomé Uribe López", "12345", "s1@gmail.com");

        // Guardando clientes en el repositorio de clientes
        clientRepository.save(client1);

        // Reservas - Cada que se hace uno, se añade al repositorio de reservas
        List<BookingElement> bookingElementsClient1 = new ArrayList<>();

        BookingElement bookingHotelClient1 = new BookingElement("h1", BookingOptions.HOTEL.getText(), 3, 100.0);
        bookingElementsClient1.add(bookingHotelClient1);
        bookingElementRepository.save(bookingHotelClient1);

        BookingElement bookingFoodClient1 = new BookingElement("f1", BookingOptions.FOOD.getText(), 3, 20.0);
        bookingElementsClient1.add(bookingFoodClient1);
        bookingElementRepository.save(bookingFoodClient1);

        BookingElement bookingTransportClient1 = new BookingElement("t1", BookingOptions.TRANSPORT.getText(), 1, 90.0);
        bookingElementsClient1.add(bookingTransportClient1);
        bookingElementRepository.save(bookingTransportClient1);

        BookingElement bookingTicketClient1 = new BookingElement("tt1", BookingOptions.TICKET.getText(), 2, 100.0);
        bookingElementsClient1.add(bookingTicketClient1);
        bookingElementRepository.save(bookingTicketClient1);

        // Una vez creadas las reservas y el cliente, se procede a guardar el
        // localizador
        Reservation reservationClient1 = new Reservation();
        reservationClient1.setClient(client1);
        reservationClient1.setBookingElements(bookingElementsClient1);
        reservationClient1.setReservationId("L1");
        reservationClient1.setTotalPrice(reservationClient1.getTotalPrice());

        // Se añade al repositorio de reservas
        reservationRepository.save(reservationClient1);
        reservationRepository.show(reservationClient1);

        /*
         * CREANDO EL SEGUNDO LOCALIZADOR
         */

        List<BookingElement> bookingElements2Client1 = new ArrayList<>();

        BookingElement bookingHotel21Client1 = new BookingElement("h11", BookingOptions.HOTEL.getText(), 3, 100.0);
        bookingElements2Client1.add(bookingHotel21Client1);
        bookingElementRepository.save(bookingHotel21Client1);

        BookingElement bookingHotel22Client1 = new BookingElement("h12", BookingOptions.HOTEL.getText(), 3, 100.0);
        bookingElements2Client1.add(bookingHotel22Client1);
        bookingElementRepository.save(bookingHotel22Client1);

        BookingElement bookingTicket21Client1 = new BookingElement("tt11", BookingOptions.TICKET.getText(), 2, 100.0);
        bookingElements2Client1.add(bookingTicket21Client1);
        bookingElementRepository.save(bookingTicket21Client1);

        BookingElement bookingTicket22Client1 = new BookingElement("tt12", BookingOptions.TICKET.getText(), 2, 100.0);
        bookingElements2Client1.add(bookingTicket22Client1);
        bookingElementRepository.save(bookingTicket22Client1);

        // Una vez creadas las reservas y el cliente, se procede a guardar el
        // localizador
        Reservation reservation2Client1 = new Reservation();
        reservation2Client1.setClient(client1);
        reservation2Client1.setBookingElements(bookingElements2Client1);
        reservation2Client1.setReservationId("L2");
        reservation2Client1.setTotalPrice(reservation2Client1.getTotalPrice());

        // Se añade al repositorio de reservas
        reservationRepository.save(reservation2Client1);
        reservationRepository.show(reservation2Client1);

        /*
         * CREANDO TERCER LOCALIZADOR
         */

        List<BookingElement> bookingElements3Client1 = new ArrayList<>();

        BookingElement bookingHotel3Client1 = new BookingElement("h3", BookingOptions.HOTEL.getText(), 3, 100.0);
        bookingElements3Client1.add(bookingHotel3Client1);
        bookingElementRepository.save(bookingHotel3Client1);

        BookingElement bookingTicket3Client1 = new BookingElement("tt3", BookingOptions.TICKET.getText(), 2, 100.0);
        bookingElements3Client1.add(bookingTicket3Client1);
        bookingElementRepository.save(bookingTicket3Client1);

        // Una vez creadas las reservas y el cliente, se procede a guardar el
        // localizador
        Reservation reservation3Client1 = new Reservation();
        reservation3Client1.setClient(client1);
        reservation3Client1.setBookingElements(bookingElements3Client1);
        reservation3Client1.setReservationId("L3");
        reservation3Client1.setTotalPrice(reservation3Client1.getTotalPrice());

        // Se añade al repositorio de reservas
        reservationRepository.save(reservation3Client1);
        reservationRepository.show(reservation3Client1);

        /*
         * Parte Opcional
         */

        // Cantidad de reservas vendidos con detalles
        showData.getBookingsCount(bookingElementRepository);

        // Cantidad total de localizadores vendidos con detalles
        showData.getReservationsCount(reservationRepository);

        // Total en ventas y promedio
        System.out.println("El total monetario de ventas fue: " + showData.getTotalSells(reservationRepository));
        System.out.println("El promedio total monetario de ventas fue: "
                + showData.getSellsAverage(bookingElementRepository, reservationRepository));

        // Diccionario clasificado de reservas
        showData.getSortedBookings(bookingElementRepository);

    }
}
