package org.miprimerproyecto.consesionariaautos.model;

import lombok.Data;

@Data
public class Services {
    String date;
    int kilometers;
    String description;

    public Services(String date, int kilometers, String description) {
        this.date = date;
        this.kilometers = kilometers;
        this.description = description;
    }
}
