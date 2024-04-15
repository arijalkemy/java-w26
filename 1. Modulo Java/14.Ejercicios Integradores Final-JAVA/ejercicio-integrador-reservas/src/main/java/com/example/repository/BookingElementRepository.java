package com.example.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.example.model.BookingElement;

public class BookingElementRepository implements IRepository<BookingElement> {

    private List<BookingElement> bookingElements;

    public BookingElementRepository() {
        this.bookingElements = new ArrayList<>();
    }

    @Override
    public void save(BookingElement bookingElement) {
        try {
            this.bookingElements.add(bookingElement);
        } catch (Exception e) {
            System.out.println("Error al agregar un elemento de reserva: Error - " + e.getMessage());
        }

    }

    @Override
    public void show(BookingElement bookingElement) {
        System.out.println(bookingElement.toString());

    }

    @Override
    public Optional<BookingElement> get(String id) {
        return bookingElements.stream()
                .filter(bookingElement -> bookingElement.getBookingElementId().equals(id))
                .findFirst();
    }

    @Override
    public void delete(String id) {
        bookingElements.removeIf(bookingElement -> bookingElement.getBookingElementId().equals(id));
    }

    @Override
    public List<BookingElement> getAll() {
        return this.bookingElements;
    }

}
