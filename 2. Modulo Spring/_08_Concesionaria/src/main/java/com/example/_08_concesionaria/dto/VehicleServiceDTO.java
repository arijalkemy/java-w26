package com.example._08_concesionaria.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter @Setter
public class VehicleServiceDTO {
    private Date date;
    private int kilometers;
    private String description;

    public VehicleServiceDTO() {
    }

    public VehicleServiceDTO(Date date, int kilometers, String description) {
        this.date = date;
        this.kilometers = kilometers;
        this.description = description;
    }
}
