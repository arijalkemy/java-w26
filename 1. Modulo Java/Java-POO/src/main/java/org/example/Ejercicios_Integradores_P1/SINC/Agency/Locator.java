package org.example.Ejercicios_Integradores_P1.SINC.Agency;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
public class Locator {

    private Client client;

    private List<Booking> bookings;

    private double total;

    public Locator(Client client, List<Booking> bookings, int discount) {
        this.client = client;
        this.bookings = bookings;
        double totalPartial = bookings.stream().mapToDouble(booking -> booking.getTypeProduct().stream().mapToDouble(TypeProduct::getPrice).sum()).sum();
        double total = totalPartial - totalPartial * discount / 100;
        this.setTotal(total);
    }
}
