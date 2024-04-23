package com.demospring.concesionariodeautos.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ServiceDTO {
    private String date;
    private double kilometers;
    private String description;

    public ServiceDTO(String date, double kilometers, String description) {
        this.date = date;
        this.kilometers = kilometers;
        this.description = description;
    }
}
