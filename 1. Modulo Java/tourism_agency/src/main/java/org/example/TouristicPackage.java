package org.example;

public class TouristicPackage {
    private short hotelReservation;
    private short food;
    private short flightTickets;
    private short transportation;

    public TouristicPackage(short hotelReservation, short food, short flightTickets, short transportation) {
        this.hotelReservation = hotelReservation;
        this.food = food;
        this.flightTickets = flightTickets;
        this.transportation = transportation;
    }

    public boolean isFullPackage() {
        return hotelReservation > 0 && food > 0 && flightTickets > 0 && transportation > 0;
    }

    public short getHotelReservation() {
        return hotelReservation;
    }

    public void setHotelReservation(short hotelReservation) {
        this.hotelReservation = hotelReservation;
    }

    public short getFood() {
        return food;
    }

    public void setFood(short food) {
        this.food = food;
    }

    public short getFlightTickets() {
        return flightTickets;
    }

    public void setFlightTickets(short flightTickets) {
        this.flightTickets = flightTickets;
    }

    public short getTransportation() {
        return transportation;
    }

    public void setTransportation(short transportation) {
        this.transportation = transportation;
    }
}
