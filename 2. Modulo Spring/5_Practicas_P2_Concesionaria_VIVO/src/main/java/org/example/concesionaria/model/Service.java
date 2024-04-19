package org.example.concesionaria.model;

import lombok.Data;
import lombok.ToString;

import java.time.LocalDate;

@Data
@ToString
public class Service {
    private LocalDate date;
    private String kilometers;
    private String descriptions;
}
