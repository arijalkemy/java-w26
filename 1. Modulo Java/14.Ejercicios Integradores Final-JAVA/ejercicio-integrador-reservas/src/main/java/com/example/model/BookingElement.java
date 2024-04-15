package com.example.model;

public class BookingElement {

    private String bookingElementId;
    private String element;
    private int quantity;
    private double price;

    public BookingElement() {

    }

    public BookingElement(String bookingElementId, String element, int quantity, double price) {
        this.bookingElementId = bookingElementId;
        this.element = element;
        this.quantity = quantity;
        this.price = price;
    }

    public void setBookingElementId(String bookingElementId) {
        this.bookingElementId = bookingElementId;
    }

    public String getBookingElementId() {
        return bookingElementId;
    }

    public void setElement(String element) {
        this.element = element;
    }

    public String getElement() {
        return element;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "\n" +
                "--------------------------------------------" + "\n" +
                "Identificador de reserva: " + this.getBookingElementId() + "\n" +
                "Nombre de elemento: " + this.getElement() + "\n" +
                "Cantidad: " + this.getQuantity() + "\n" +
                "Price: " + this.getPrice() + "\n" +
                "--------------------------------------------";
    }

}
