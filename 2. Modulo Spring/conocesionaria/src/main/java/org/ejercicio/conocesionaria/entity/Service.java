package org.ejercicio.conocesionaria.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Setter
@Getter
public class Service {
    private UUID id;
    private LocalDate date;
    private int kilometers;
    private String descriptions;

    public Service(LocalDate date, int kilometers, String descriptions) {
        this.id = UUID.randomUUID();
        this.date = date;
        this.kilometers = kilometers;
        this.descriptions = descriptions;
    }
}
