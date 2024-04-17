package com.practicaSpring.concesionariaDeAutos.model;

import lombok.Getter;

import java.time.LocalDate;

@Getter
public class Service {
    private LocalDate date;
    private Long kilometers;
    private String descriptions;

    public Service(LocalDate date, Long kilometers, String descriptions) {
        this.date = date;
        this.kilometers = kilometers;
        this.descriptions = descriptions;
    }
}
