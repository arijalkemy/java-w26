package org.example.model;

import java.util.ArrayList;
import java.util.List;

public class Client {

    String discount;
    List<Ticket> ticketList;


    public Client() {

        discount = "";
        ticketList = new ArrayList<>();
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {

    }

    public List<Ticket> allTickets(){
        return this.ticketList;
    }

    public void appendTicket(Ticket ticket){

        ticketList.add(ticket);

        //Check if all fields are purchased
        if(ticket.isCompleteBundle()){
            this.discount += " 0.05";
        }
        //Check length of ticketList to
        if(ticketList.size() >=  3){
            this.discount += "+ 0.05";
        }

        if (checkIfDiscount()){
            this.discount += "+ 0.1";
        }
        ticket.setTotal(this.discount);
    }

    private  Boolean checkIfDiscount(){
        return this.ticketList.stream().
                mapToInt(Ticket::getHotel).
                sum() >= 2
                ||
                this.ticketList.stream().
                        mapToInt(Ticket::getPlaneTickets)
                        .sum() >= 2;
    }
}
