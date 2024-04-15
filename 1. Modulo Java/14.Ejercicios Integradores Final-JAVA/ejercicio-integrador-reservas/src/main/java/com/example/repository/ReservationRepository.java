package com.example.repository;

import java.util.Optional;
import java.util.ArrayList;
import java.util.List;

import com.example.model.Reservation;

public class ReservationRepository implements IRepository<Reservation> {

    private List<Reservation> reservations;

    public ReservationRepository() {
        reservations = new ArrayList<>();
    }

    @Override
    public void save(Reservation reservation) {
        double totalDiscount = 0;
        double finalValue = 0;
        try {

            if ((this.reservations.stream().filter(reserv -> reserv.getClient().equals(reservation.getClient()))
                    .count()) >= 2) {
                totalDiscount = 0.05;
            }

            finalValue = reservation.getTotalPrice() - reservation.getTotalPrice() * totalDiscount;
            reservation.setTotalPrice(finalValue);
            reservations.add(reservation);

        } catch (Exception e) {
            System.out.println("Hubo un error al guardar la reservación: Error - " + e.getMessage());
        }
    }

    @Override
    public void show(Reservation reservation) {
        System.out.println(reservation.toString());
    }

    @Override
    public Optional<Reservation> get(String id) {
        return this.reservations.stream()
                .filter(reservation -> reservation.getReservationId().equals(id))
                .findFirst();
    }

    @Override
    public void delete(String id) {
        this.reservations.removeIf(reservation -> reservation.getReservationId().equals(id));
    }

    @Override
    public List<Reservation> getAll() {
        return this.reservations;
    }

}
