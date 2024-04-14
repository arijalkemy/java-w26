package org.example.tourist;

public class Invoice {
    private TourPackage reservas;
    private Client client;

    public Invoice(TourPackage reserva, Client client) {
        this.reservas = reserva;
        this.client = client;
    }

    public TourPackage getReserva() {
        return reservas;
    }

    public void setReservas(TourPackage reservas) {
        this.reservas = reservas;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public double getPriceDiscount(){
        double discount = 1.0;
        if (reservas.getTicket() > 0 && reservas.getFood() > 0 && reservas.getHotel() > 0 && reservas.getTransport() > 0) {
            discount -= 0.10;
        }
        if(reservas.getHotel() == 2 || reservas.getTicket() == 2){
           discount -= 0.05;
        }
        if(client.getDiscount()){
            discount -= 0.05;
        }
        return reservas.getPrice() * discount;
    }

    @Override
    public String toString() {
        return client + " - " + String.join("\n\t", this.reservas.toString());
    }
}
