package org.example.model;

import java.lang.reflect.Array;

public class Ticket {
    Integer hotel;
    Integer food;
    Integer planeTickets;
    Integer transport;
    String total;



    public Ticket() {
        this.hotel = 0;
        this.food = 0;
        this.planeTickets = 0;
        this.transport = 0;


    }
    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }
    public Integer getHotel() {
        return hotel;
    }

    public void setHotel(Integer hotel) {
        this.hotel = hotel;
    }

    public Integer getFood() {
        return food;
    }

    public void setFood(Integer food) {
        this.food = food;
    }

    public Integer getPlaneTickets() {
        return planeTickets;
    }

    public void setPlaneTickets(Integer planeTickets) {
        this.planeTickets = planeTickets;
    }

    public Integer getTransport() {
        return transport;
    }

    public void setTransport(Integer transport) {
        this.transport = transport;
    }

    /**
     * Checks if the client purchased all bundle fields
     * @return True or false
     */

    public Boolean isCompleteBundle(){
        if(this.hotel > 0 & this.food > 0 & this.planeTickets > 0 & this.transport > 0){
            return Boolean.TRUE;
        }else {
            return Boolean.FALSE;
        }
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "hotel=" + hotel +
                ", food=" + food +
                ", planeTickets=" + planeTickets +
                ", transport=" + transport +
                ", total=" + total + "off discount" +
                '}';
    }
}
