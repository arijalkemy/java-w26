package com.mercadolibre.DeportistasAPI.DTO;

import java.io.Serializable;

public class PersonaDTO implements Serializable {
    private String nombreCompleto;
    private String nombreDeporte;

    public PersonaDTO(String nombreCompleto, String nombreDeporte) {
        this.nombreCompleto = nombreCompleto;
        this.nombreDeporte = nombreDeporte;
    }

    @Override
    public String toString() {
        return "PersonaDTO{" +
                "nombreCompleto='" + nombreCompleto + '\'' +
                ", nombreDeporte='" + nombreDeporte + '\'' +
                '}';
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getNombreDeporte() {
        return nombreDeporte;
    }

    public void setNombreDeporte(String nombreDeporte) {
        this.nombreDeporte = nombreDeporte;
    }
}
