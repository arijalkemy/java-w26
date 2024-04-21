package com.example.ejercicio_arquitectura_multicapa_p2_vivo_concesionaria_de_autos.entity;

public class Service {
    private String date;
    private String kilometers;
    private String descriptions;

    public Service() {
    }

    public Service(String date, String kilometers, String descriptions) {
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

    public String getKilometers() {
        return kilometers;
    }

    public void setKilometers(String kilometers) {
        this.kilometers = kilometers;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }
}
