package org.example.tourist;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Client> clients = Arrays.asList(
                new Client(1, "Edwin", "Villarraga"),
                new Client(2, "Camilo", "Gomez")
        );
        Agency localizador = new Agency(Arrays.asList(
                new Invoice(
                        new TourPackage(1, 1, 1, 1, 2000),
                        clients.get(0)),
                new Invoice(
                        new TourPackage(2, 2, 0, 0, 4000),
                        clients.get(1)),
                new Invoice(
                        new TourPackage(0, 1, 0, 0, 500),
                        clients.get(1))
        ), clients);
        localizador.assignDiscount();
        System.out.println("Total: " + localizador.getTotalClient(1));
    }
}
