package com.example.concesionario.entity;

import lombok.*;

import java.time.LocalDate;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Service {
    private LocalDate date;
    private int kilometers;
    private String description;

}
