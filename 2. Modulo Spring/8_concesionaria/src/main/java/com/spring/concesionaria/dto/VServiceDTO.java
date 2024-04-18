package com.spring.concesionaria.dto;

import lombok.Getter;

import java.io.Serializable;

@Getter
public class VServiceDTO implements Serializable {

    private String date;
    private Double kilometers;
    private String descriptions;

    public VServiceDTO(String date, Double kilometers, String descriptions) {
        this.date = date;
        this.kilometers = kilometers;
        this.descriptions = descriptions;
    }

}
