package com.example._08_concesionaria.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter @Setter
public class VehicleService {
    private Date date;
    private int kilometers;
    private String description;

    public VehicleService() {
    }

    public VehicleService(Date date, int kilometers, String description) {
        this.date = date;
        this.kilometers = kilometers;
        this.description = description;
    }
}
