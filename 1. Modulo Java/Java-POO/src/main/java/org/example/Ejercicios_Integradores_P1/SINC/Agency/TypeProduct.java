package org.example.Ejercicios_Integradores_P1.SINC.Agency;

import lombok.Getter;
import lombok.Setter;

@Getter
public enum TypeProduct {

    TOURIST_PACKAGE("Tourist Package", 100 ),
    HOSTEL("Hostel", 100 ),
    FOOD("Food", 20 ),
    TRAVEL_TICKETS("Travel Tickets", 80),
    TRANSPORT("Transport", 15 );

    private final String value;

    @Setter
    private  double price;

    TypeProduct(String valor,  int price) {
        this.value = valor;
        this.price = price;
    }

}
