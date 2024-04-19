package com.meli.concesionaria.entity;

public class Service {
   private String date;
   private Integer kilometers;
   private String descriptions;

    public Service(String date, Integer kilometers, String descriptions) {
        this.date = date;
        this.kilometers = kilometers;
        this.descriptions = descriptions;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Integer getKilometers() {
        return kilometers;
    }

    public void setKilometers(Integer kilometers) {
        this.kilometers = kilometers;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    @Override
    public String toString() {
        return "Service{" +
                "date='" + date + '\'' +
                ", kilometers=" + kilometers +
                ", descriptions='" + descriptions + '\'' +
                '}';
    }
}
