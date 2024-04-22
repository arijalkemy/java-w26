package com.example.concesionaria_autos.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Service {
    private String date;
    private Integer kilometers;
    private String description;
}
