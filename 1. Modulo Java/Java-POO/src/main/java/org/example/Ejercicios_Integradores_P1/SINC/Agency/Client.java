package org.example.Ejercicios_Integradores_P1.SINC.Agency;

import lombok.Data;

@Data
public class Client {

    private int id;

    private String name;

    private int discount;

    public Client(int id, String name) {
        this.id = id;
        this.name = name;
        this.discount = 0;
    }
}
