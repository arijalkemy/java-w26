package org.example.concesionariaautos.model;

import lombok.Data;

import java.time.LocalDate;

@Data
public class Service {
    private LocalDate date;
    private double kilometers;
    private String description;
}
