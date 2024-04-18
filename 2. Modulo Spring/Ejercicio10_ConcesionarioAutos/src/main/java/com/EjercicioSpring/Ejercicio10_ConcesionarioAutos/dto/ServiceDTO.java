package com.EjercicioSpring.Ejercicio10_ConcesionarioAutos.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;

@FieldDefaults(level = AccessLevel.PRIVATE) // Ayuda a no tenter que poner el private, por defecto vienen privado
@Builder //No afecta el orden de la entidad (leer más)
@Data
public class ServiceDTO implements Serializable {
    @JsonProperty("date")
    private String date;

    @JsonProperty("kilometers")
    private int kilometers;

    @JsonProperty("description")
    private String description;

    public ServiceDTO(String date, int kilometers, String description) {
        this.date = date;
        this.kilometers = kilometers;
        this.description = description;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getKilometers() {
        return kilometers;
    }

    public void setKilometers(int kilometers) {
        this.kilometers = kilometers;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
