package com.EjercicioSpring.Ejercicio10_ConcesionarioAutos.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
public class Service {
    @Id
    private Integer id;
    private Integer idVehicle;
    private LocalDate date;
    private int kilometers;
    private String description;

    public Service(Integer id, Integer idVehicle, LocalDate date, int kilometers, String description) {
        this.id = id;
        this.idVehicle = idVehicle;
        this.date = date;
        this.kilometers = kilometers;
        this.description = description;
    }

    public Service(Integer idVehicle, LocalDate date, int kilometers, String description) {
        this.idVehicle = idVehicle;
        this.date = date;
        this.kilometers = kilometers;
        this.description = description;
    }

    public Service() {

    }
}
