package com.example;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.model.BookingElement;
import com.example.model.Reservation;
import com.example.repository.BookingElementRepository;
import com.example.repository.ReservationRepository;

public class ShowData {

    public ShowData() {

    }

    /*
     * Método para consultar la cantidad de reservas hechas hasta el momento(hotel,
     * comida, transporte, etc)
     * e imprimir la información de cada una
     */
    public void getBookingsCount(BookingElementRepository bookingElementRepository) {
        long counter = bookingElementRepository.getAll().stream().count();
        System.out.println("Se han hecho un total de " + counter + " reservas hasta el momento");

        List<BookingElement> auxList = bookingElementRepository.getAll();

        for (BookingElement bookingElement : auxList) {
            bookingElementRepository.show(bookingElement);
        }
    }

    /*
     * Método para consultar la cantidad de localizadores hechos hasta el momento
     * e imprimir la información de cada uno
     */
    public void getReservationsCount(ReservationRepository reservationRepository) {
        long counter = reservationRepository.getAll().stream().count();
        System.out.println("Se han hecho un total de " + counter + " Localizadores hasta el momento");

        List<Reservation> auxList = reservationRepository.getAll();

        for (Reservation reservation : auxList) {
            reservationRepository.show(reservation);
        }
    }

    /*
     * Método para filtrar la data del repositorio en listas y añadirlas a un
     * diccionario
     */

    public void getSortedBookings(BookingElementRepository bookingElementRepository) {

        Map<String, List<BookingElement>> sortedDict = new HashMap<>();

        List<BookingElement> hotelList;
        List<BookingElement> foodList;
        List<BookingElement> ticketList;
        List<BookingElement> transportList;

        // Filtrando elementos para las listas
        hotelList = bookingElementRepository.getAll().stream()
                .filter(booking -> booking.getElement().equals(BookingOptions.HOTEL.getText())).toList();
        foodList = bookingElementRepository.getAll().stream()
                .filter(booking -> booking.getElement().equals(BookingOptions.FOOD.getText())).toList();
        ticketList = bookingElementRepository.getAll().stream()
                .filter(booking -> booking.getElement().equals(BookingOptions.TICKET.getText())).toList();
        transportList = bookingElementRepository.getAll().stream()
                .filter(booking -> booking.getElement().equals(BookingOptions.TRANSPORT.getText())).toList();

        // Añadiendo listas al diccionario
        sortedDict.put(BookingOptions.HOTEL.getText(), hotelList);
        sortedDict.put(BookingOptions.FOOD.getText(), foodList);
        sortedDict.put(BookingOptions.TICKET.getText(), ticketList);
        sortedDict.put(BookingOptions.TRANSPORT.getText(), transportList);

        for (Map.Entry<String, List<BookingElement>> entry : sortedDict.entrySet()) {
            String key = entry.getKey();
            List<BookingElement> value = entry.getValue();

            System.out.println("Reserva de tipo: " + key);
            for (BookingElement bookingElement : value) {
                System.out.println(bookingElement.toString());
            }

        }
    }

    /*
     * Método para obtener el total vendido
     */
    public Double getTotalSells(ReservationRepository reservationRepository) {
        double total = 0;

        for (Reservation reservation : reservationRepository.getAll()) {
            total += reservation.getTotal();
        }
        return total;
    }

    /*
     * Método para obtener el promedio de ventas
     */
    public Double getSellsAverage(BookingElementRepository bookingElementRepository,
            ReservationRepository reservationRepository) {

        double total;
        long count;
        count = bookingElementRepository.getAll().stream().count();
        total = getTotalSells(reservationRepository) / count;

        return total;
    }

}
