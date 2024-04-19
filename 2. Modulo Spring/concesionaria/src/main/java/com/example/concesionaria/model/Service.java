package com.example.concesionaria.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class Service {
    private LocalDate date;
    private int kilometers;
    private String description;
}
