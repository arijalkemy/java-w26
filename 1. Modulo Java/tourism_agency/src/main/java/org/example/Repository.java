package org.example;

import java.util.*;
import java.util.stream.Collectors;

public class Repository extends Throwable {
    private List<Locator> locatorList;
    private List<Client> clientList;

    public Repository() {
        this.locatorList = new ArrayList<>();
        this.clientList = new ArrayList<>();
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
        Client foundClient;
        try {
            foundClient = this.clientList.stream()
                    .filter(client -> client.getDni() == clientDni)
                    .findAny()
                    .orElse(null);
        } catch (NullPointerException ex) {
            foundClient = null;
        }

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
        List<TouristicPackage> pack = createTourPack(userInput);
        // 3. Create the Locator
        createLocator(foundClient, pack);
    }

    public List<TouristicPackage> createTourPack(Scanner userInput) {
        System.out.println("A continuación, ingresa los datos del paquete");
        System.out.println("Cantidad reserva hoteles:");
        short hotelQuant = userInput.nextShort();
        System.out.println("Cantidad comida:");
        short foodQuant = userInput.nextShort();
        System.out.println("Cantidad vuelos:");
        short flightQuan = userInput.nextShort();
        System.out.println("Cantidad transporte:");
        short transpQuant = userInput.nextShort();

        List<TouristicPackage> newPackage = new ArrayList<>();

        if (hotelQuant > 0) newPackage.add(
                new TouristicPackage(TouristicPackage.ResType.HOTEL,
                hotelQuant,
                TouristicPackage.FixedPrices.HOTEL.getPrice())
        );
        if (foodQuant > 0) newPackage.add(
                new TouristicPackage(TouristicPackage.ResType.FOOD,
                        foodQuant,
                        TouristicPackage.FixedPrices.FOOD.getPrice())
        );
        if (flightQuan > 0) newPackage.add(
                new TouristicPackage(TouristicPackage.ResType.FLIGHT_TICKETS,
                        flightQuan,
                        TouristicPackage.FixedPrices.FLIGHT_TICKETS.getPrice())
        );
        if (transpQuant > 0) newPackage.add(
                new TouristicPackage(TouristicPackage.ResType.TRANSPORTATION,
                        transpQuant,
                        TouristicPackage.FixedPrices.TRANSPORTATION.getPrice())
        );

        return newPackage;
    }

    public void createLocator(Client client, List<TouristicPackage> tourPack) {
        float discount = 0.0f;
        float bookingDiscount = 0.0f;
        double total = 0;
        List<Locator> histLocators = getLocatorsByClient(client);
        TouristicPackage hotelBooking = getTourPackByType(tourPack, TouristicPackage.ResType.HOTEL);
        TouristicPackage flightBooking = getTourPackByType(tourPack, TouristicPackage.ResType.HOTEL);

        boolean hasHotelDiscount = hotelBooking != null && hotelBooking.getQuantity() > 1;
        boolean hasFlightDiscount = flightBooking != null && flightBooking.getQuantity() > 1;

        if (histLocators != null && !histLocators.isEmpty()) {
            if (histLocators.size() >= 2) discount += 0.05f;
            if (tourPack.size() == 4) discount += 0.1f;
            if (hasHotelDiscount || hasFlightDiscount) bookingDiscount += 0.05f;
        }

        for (TouristicPackage aPackage : tourPack) {
            boolean canHaveDiscount = aPackage.getType() == TouristicPackage.ResType.HOTEL ||
                    aPackage.getType() == TouristicPackage.ResType.FLIGHT_TICKETS;
            total += canHaveDiscount ? aPackage.getPrice() * (1-bookingDiscount) : aPackage.getPrice();
        }

        total = total * (1-discount);

        Locator newLocator = new Locator(client, total, tourPack);
        this.locatorList.add(newLocator);
        newLocator.printDetails();
    }

    public TouristicPackage getTourPackByType(List<TouristicPackage> tourPack, TouristicPackage.ResType type) {
        return tourPack.stream()
                .filter(pack -> pack.getType() == type)
                .findAny()
                .orElse(null);
    }

    public String getSummary() {
        int locSold = this.locatorList.size();
        int tourPackQ = this.locatorList.stream()
                .mapToInt(loc ->
                    loc.getTouristicPackages().stream()
                            .mapToInt(TouristicPackage::getQuantity)
                            .sum()
                ).sum();
        Map<TouristicPackage.ResType, List<TouristicPackage>> listMap = getClassifiedMap();
        int totalSold = this.locatorList.stream()
                .mapToInt(loc ->
                        loc.getTouristicPackages().stream()
                                .mapToInt(TouristicPackage::getPrice)
                                .sum()
                ).sum();
        float avgSold = (float) totalSold / tourPackQ;
        return "Cantidad localizadores vendidos: "+locSold+"\n"+
                "Cantidad total reservas: "+tourPackQ+"\n"+
                "Reservas clasificadas: "+listMap+"\n"+
                "Total ventas: "+totalSold+"\n"+
                "Promedio ventas: "+avgSold;
    }

    public Map<TouristicPackage.ResType, List<TouristicPackage>> getClassifiedMap() {
        Map<TouristicPackage.ResType, List<TouristicPackage>> listMap = new HashMap<>();
        this.locatorList.forEach(locList -> {
            locList.getTouristicPackages().forEach(tourPack -> {
                if (!listMap.containsKey(tourPack.getType())) {
                    listMap.put(tourPack.getType(), new ArrayList<>());
                }
                listMap.get(tourPack.getType()).add(tourPack);
            });
        });
        return listMap;
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
