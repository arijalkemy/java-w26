package org.example.Ejercicios_Integradores_P1.SINC;

import lombok.Getter;
import lombok.Setter;
import org.example.Ejercicios_Integradores_P1.SINC.Repository.RepositoryClient;

import java.util.List;

@Getter
public class Locator {

    @Setter
    private Client client;

    @Setter
    private List<Booking> bookings;

    private double total;


    public Locator(Client client, List<Booking> bookings) {
        this.client = client;
        this.bookings = bookings;
        // Calculate total
        double totalParcial = bookings.stream().mapToDouble(booking -> booking.getTypeProduct().stream().mapToDouble(TypeProduct::getPrice).sum()).sum();
        double discountByClient =  totalParcial * client.getDiscount() / 100;
        this.total = totalParcial - discountByClient;
    }

}
