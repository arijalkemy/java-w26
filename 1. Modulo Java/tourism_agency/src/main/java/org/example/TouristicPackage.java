package org.example;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TouristicPackage {

    public enum ResType {
        HOTEL,
        FOOD,
        FLIGHT_TICKETS,
        TRANSPORTATION
    }

    public enum FixedPrices {
        HOTEL(1000), FOOD(500), FLIGHT_TICKETS(900), TRANSPORTATION(600);
        private int price;
        FixedPrices(int price){
            this.price = price;
        }

        public int getPrice() {
            return price;
        }
    }

    private final Map<ResType, String> displayName = Stream.of(
            new AbstractMap.SimpleEntry<>(ResType.HOTEL, "Hotel"),
                    new AbstractMap.SimpleEntry<>(ResType.FOOD, "Comida"),
                    new AbstractMap.SimpleEntry<>(ResType.FLIGHT_TICKETS, "Boletos de viaje"),
                    new AbstractMap.SimpleEntry<>(ResType.TRANSPORTATION, "Transporte")
            )
            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

    private ResType type;
    private short quantity;
    private int price;

    public TouristicPackage(ResType type, short quantity, int price) {
        this.type = type;
        this.quantity = quantity;
        this.price = price;
    }

    public String getDisplayName() {
        return displayName.get(this.type);
    }

    public ResType getType() {
        return type;
    }

    public void setType(ResType type) {
        this.type = type;
    }

    public short getQuantity() {
        return quantity;
    }

    public void setQuantity(short quantity) {
        this.quantity = quantity;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
