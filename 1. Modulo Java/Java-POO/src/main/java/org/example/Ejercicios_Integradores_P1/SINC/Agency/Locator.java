package org.example.Ejercicios_Integradores_P1.SINC.Agency;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Locator {

    @Setter
    private Client client;

    @Setter
    private List<Booking> bookings;

    private  double total;


    public Locator newLocator(Client client, List<Booking> bookings, List<Client> clientsList) {
        Client cli = clientsList.stream().filter(e -> e.getId() == client.getId()).toList().getFirst();
        // Calculate total
        double totalPartial = bookings.stream().mapToDouble(booking -> booking.getTypeProduct().stream().mapToDouble(TypeProduct::getPrice).sum()).sum();
        double discountByClient =  totalPartial * cli.getDiscount() / 100;
        double total = totalPartial - discountByClient;
        return new Locator(cli, bookings, total);
    }

}
