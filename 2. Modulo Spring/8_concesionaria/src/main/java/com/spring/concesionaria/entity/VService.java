package com.spring.concesionaria.entity;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class VService {

    private LocalDate date;
    private Double kilometers;
    private String descriptions;

    public VService(LocalDate date, Double kilometers, String descriptions) {
        this.date = date;
        this.kilometers = kilometers;
        this.descriptions = descriptions;
    }
}
