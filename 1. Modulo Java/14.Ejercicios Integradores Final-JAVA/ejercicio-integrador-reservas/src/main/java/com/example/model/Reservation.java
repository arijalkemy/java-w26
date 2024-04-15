package com.example.model;

import java.util.List;

public class Reservation {

    private String reservationId;
    private Client client;
    private List<BookingElement> bookingElements;
    private double totalPrice;

    public Reservation() {

    }

    public Reservation(String reservationId, Client client, List<BookingElement> bookingElements, double totalPrice) {
        this.reservationId = reservationId;
        this.client = client;
        this.bookingElements = bookingElements;
        this.totalPrice = totalPrice;
    }

    public void setBookingElements(List<BookingElement> bookingElements) {
        this.bookingElements = bookingElements;
    }

    public List<BookingElement> getBookingElements() {
        return bookingElements;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Client getClient() {
        return client;
    }

    public void setReservationId(String reservationId) {
        this.reservationId = reservationId;
    }

    public String getReservationId() {
        return reservationId;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public double getTotal() {
        return totalPrice;
    }

    public double getTotalPrice() {

        double totalDiscount = 0;
        int hotelCounter = 0, ticketCounter = 0, foodCounter = 0, transportCounter = 0;
        double totalValue = 0;

        for (BookingElement bookingElement : bookingElements) {

            switch (bookingElement.getElement()) {
                case "hotel":
                    hotelCounter++;
                    break;
                case "boleto":
                    ticketCounter++;
                    break;
                case "comida":
                    foodCounter++;
                    break;
                case "transporte":
                    transportCounter++;
                    break;
                default:
                    break;
            }

            totalValue += bookingElement.getPrice() * bookingElement.getQuantity();
        }

        if ((hotelCounter >= 2) && (ticketCounter >= 2)) {
            totalDiscount = 0.05;
        }
        if (hotelCounter >= 1 && ticketCounter >= 1 && foodCounter >= 1 && transportCounter >= 1) {
            totalDiscount = 0.10;
        }
        totalValue = totalValue - totalValue * totalDiscount;

        return totalValue;
    }

    public String getListString(List<BookingElement> elements) {
        String str = "";
        for (BookingElement element : elements) {
            str = str + element.toString();
        }
        return str;
    }

    @Override
    public String toString() {
        return "\n" +
                "-------------------------------------------------------" + "\n" +
                "Id de Reservación: " + this.getReservationId() + "\n" +
                "Client: " + this.getClient() + "\n" +
                "Reserva: " + getListString(this.getBookingElements()) + "\n" +
                "Total: " + totalPrice + "\n" +
                "-------------------------------------------------------";
    }
}
