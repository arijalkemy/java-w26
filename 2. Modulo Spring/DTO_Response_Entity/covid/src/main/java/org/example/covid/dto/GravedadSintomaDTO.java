package org.example.covid.dto;

import java.io.Serializable;

public class GravedadSintomaDTO implements Serializable {
    private String gravedad;

    public String getGravedad() {
        return gravedad;
    }


    public GravedadSintomaDTO(String gravedad) {
        this.gravedad = gravedad;
    }
}
