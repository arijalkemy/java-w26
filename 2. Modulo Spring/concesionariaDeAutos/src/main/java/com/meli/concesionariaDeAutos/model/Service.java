package com.meli.concesionariaDeAutos.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Service {
    private String date;
    private Integer kilometers;
    private String descriptions;

    public Service(String date, Integer kilometers, String descriptions) {
        this.date = date;
        this.kilometers = kilometers;
        this.descriptions = descriptions;
    }
}
