package org.example.Ejercicios_Integradores_P1.SINC.Agency;

import lombok.Data;
import org.example.Ejercicios_Integradores_P1.SINC.Agency.Repository.RepositoryClient;
import org.example.Ejercicios_Integradores_P1.SINC.Agency.Repository.RepositoryLocator;

import java.util.List;


@Data
public class Agency {

    private final RepositoryLocator locatorRepository;
    private final RepositoryClient clientRepository;

    public Agency(RepositoryLocator locatorRepository, RepositoryClient clientRepository) {
        this.locatorRepository = locatorRepository;
        this.clientRepository = clientRepository;
    }

    public void registerClient(Client newClient) {
        this.getClientRepository().add(newClient);
    }

    public void registerLocator(Client client, List<Booking> bookings) {
        int totalDiscount = discountByAmountLocators(client);
        totalDiscount += discountSByTouristPackage(bookings);

        discountSpecialPromo(bookings);

        Locator newLocator = new Locator(client, bookings, totalDiscount);

        this.locatorRepository.add(newLocator);
    }

    public int discountByAmountLocators(Client client) {
        int countClient = this.getLocatorRepository().getLocators().stream().filter(l -> l.getClient().equals(client)).toArray().length;
        if (countClient >= 2) return 5;
        else return 0;
    }

    private int discountSByTouristPackage(List<Booking> bookings) {
        boolean hasTouristPackage = bookings.stream().anyMatch(booking -> booking.getTypeProduct().contains(TypeProduct.TOURIST_PACKAGE));
        if (hasTouristPackage) return 10;
        else return 0;
    }

    private void discountSpecialPromo(List<Booking> bookings) {
        int countHostel = (int) bookings.stream()
                .flatMap(booking -> booking.getTypeProduct().stream())
                .filter(typeProduct -> typeProduct.equals(TypeProduct.HOSTEL)).count();
        int countTravelTickets = (int) bookings.stream()
                .flatMap(booking -> booking.getTypeProduct().stream())
                .filter(typeProduct -> typeProduct.equals(TypeProduct.TRAVEL_TICKETS)).count();

        if (countHostel >= 2)
            applyDiscount(bookings, TypeProduct.HOSTEL);

        if (countTravelTickets >= 2)
            applyDiscount(bookings, TypeProduct.TRAVEL_TICKETS);
    }

    private void applyDiscount(List<Booking> bookings, TypeProduct product) {
        double price =
                bookings.stream().filter(booking -> booking.getTypeProduct().contains(product)).findFirst().get().getTypeProduct().getFirst().getPrice();
        double newPrice = price - (price * 5) / 100;
        bookings
                .stream()
                .flatMap(booking -> booking.getTypeProduct().stream())
                .filter(typeProduct -> typeProduct.equals(product))
                .forEach(typeProduct -> typeProduct.setPrice(newPrice));

    }


}
