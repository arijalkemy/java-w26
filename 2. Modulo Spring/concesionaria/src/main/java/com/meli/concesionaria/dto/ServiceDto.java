package com.meli.concesionaria.dto;

public class ServiceDto {
    private String date;
    private Integer kilometers;
    private String descriptions;

    public ServiceDto(String date, Integer kilometers, String descriptions) {
        this.date = date;
        this.kilometers = kilometers;
        this.descriptions = descriptions;
    }

    public String getDate() {
        return date;
    }

    public Integer getKilometers() {
        return kilometers;
    }

    public String getDescriptions() {
        return descriptions;
    }

    @Override
    public String toString() {
        return "ServiceDto{" +
                "date='" + date + '\'' +
                ", kilometers=" + kilometers +
                ", descriptions='" + descriptions + '\'' +
                '}';
    }
}
