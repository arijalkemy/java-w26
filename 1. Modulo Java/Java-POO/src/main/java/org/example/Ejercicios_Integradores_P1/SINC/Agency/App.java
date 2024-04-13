package org.example.Ejercicios_Integradores_P1.SINC.Agency;

import org.example.Ejercicios_Integradores_P1.SINC.Agency.Repository.RepositoryClient;
import org.example.Ejercicios_Integradores_P1.SINC.Agency.Repository.RepositoryLocator;

import java.util.List;


public class App {

    public static void main(String[] args) {

        Client clientJuan = new Client(1, "Juan");
        RepositoryClient clientRepository = new RepositoryClient();
        RepositoryLocator locatorRepository = new RepositoryLocator(clientRepository);

        Agency agency = new Agency(locatorRepository, clientRepository);

        agency.registerClient(clientJuan);

        agency.registerLocator(clientJuan,
                List.of(new Booking((List.of(TypeProduct.HOSTEL, TypeProduct.HOSTEL)))));
        agency.registerLocator(clientJuan, List.of(new Booking((List.of(TypeProduct.TOURIST_PACKAGE)))));


        clientRepository.getClients().forEach(System.out::println);
        agency.getLocatorRepository().getLocators().forEach((e) -> System.out.println(e.getTotal()));


        //agency.getRepo().addLocator(new Locator(new Client(2, "Pedro"), List.of(new Booking((List.of(TypeProduct.FOOD,TypeProduct.FOOD,TypeProduct.TRANSPORT))))));

        //agency.getRepo().getLocators().stream().forEach(locator -> System.out.println(locator.getClient().getName() + " " + locator.getTotal()));
    }
}
