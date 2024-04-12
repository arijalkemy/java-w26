package org.example;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Repository extends Throwable {
    private List<Locator> locatorList;
    private List<Client> clientList;

    public Repository() {
    }

    public void addLocator(Locator newLocator) {
        this.locatorList.add(newLocator);
        newLocator.printDetails();
    }

    public Client registerNewClient(Long dni) {
        Scanner userInput = new Scanner(System.in);
        long userDni;
        if (dni == null) {
            System.out.println("Ingresa tu DNI");
            userDni = userInput.nextLong();
        } else {
            userDni = dni;
        }
        System.out.println("Ingresa tu nombre:");
        String name = userInput.next();
        System.out.println("Ingresa tu apellido:");
        String lastname = userInput.next();
        Client newClient = new Client(userDni, name, lastname);
        this.clientList.add(newClient);
        return newClient;
    }

    public Client getClientByDni(long clientDni){
        Client foundClient = this.clientList.stream()
                .filter(client -> client.getDni() == clientDni)
                .findAny()
                .orElse(null);

        if (foundClient == null) {
            System.out.println("No se encontró ese usuario, por favor realiza el registro del usuario.");
            foundClient = registerNewClient(clientDni);
        }

        return foundClient;
    }

    public List<Locator> getLocatorsByClient(Client client){
        return this.locatorList.stream()
                .filter(loc -> loc.getClient() == client)
                .collect(Collectors.toList());
    }

    public void appFlow() {
        Scanner userInput = new Scanner(System.in);
        // 1. Find or register client
        System.out.println("Ingresa el DNI del usuario:");
        long userDni = userInput.nextLong();
        Client foundClient = getClientByDni(userDni);
        // 2. With the client, create the Tourist Package
        TouristicPackage pack = createTourPack(userInput);
        // 3. Create the Locator
        createLocator(foundClient, pack);
    }

    public TouristicPackage createTourPack(Scanner userInput) {
        System.out.println("A continuación, ingresa los datos del paquete");
        System.out.println("Cantidad reserva hoteles:");
        short hotelQuant = userInput.nextShort();
        System.out.println("Cantidad comida:");
        short foodQuant = userInput.nextShort();
        System.out.println("Cantidad vuelos:");
        short flightQuan = userInput.nextShort();
        System.out.println("Cantidad transporte:");
        short transpQuant = userInput.nextShort();
        return new TouristicPackage(hotelQuant,foodQuant, flightQuan, transpQuant);
    }

    public void createLocator(Client client, TouristicPackage tourPack) {
        List<Locator> histLocators = getLocatorsByClient(client);
        float discount = 0.0f;
        float bookingDiscount = 0.0f;
        if (histLocators != null && !histLocators.isEmpty()) {
            if (histLocators.size() >= 2) discount += 0.05f;
            if (tourPack.isFullPackage()) discount += 0.1f;
            if (tourPack.getHotelReservation() > 1 || tourPack.getFlightTickets() > 1) bookingDiscount += 0.05f;
        }
        /**
         * # Presentar un escenario donde:
         *
         * - Crear un localizador con un paquete completo para un cliente, almacenar e imprimir el resultado.
         * - Crear un localizador con 2 reservas de hotel y 2 de boletos para el mismo cliente anterior, almacenar e imprimir el resultado.
         * - Crear un localizador con una sola reserva para el mismo cliente.
         * - Verificar que los descuentos fueron aplicados.
         *
         * # Agregar una clase que permita realizar las siguientes consultas sobre los localizadores vendidos, empleando diferentes métodos que muestren:
         *
         * - Cantidad de localizadores vendidos.
         * - Cantidad total de reservas.
         * - Obtener un diccionario de todas las reservas clasificados por tipo (hotel, boleto,comida,transporte).
         * - Total de ventas.
         * - Promedio de todas las ventas.
         */

        Locator newLocator = new Locator(client, 0, Collections.singletonList(tourPack));
        this.locatorList.add(newLocator);
        newLocator.printDetails();
    }

    public List<Locator> getLocatorList() {
        return locatorList;
    }

    public void setLocatorList(List<Locator> locatorList) {
        this.locatorList = locatorList;
    }

    public List<Client> getClientList() {
        return clientList;
    }

    public void setClientList(List<Client> clientList) {
        this.clientList = clientList;
    }
}
