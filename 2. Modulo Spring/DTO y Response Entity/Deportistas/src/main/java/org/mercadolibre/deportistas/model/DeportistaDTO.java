package org.mercadolibre.deportistas.model;

import java.io.Serializable;

public class DeportistaDTO implements Serializable {
    private String nombreCompleto;
    private String nombreDeporte;

    public DeportistaDTO(String nombreCompleto, String nombreDeporte) {
        this.nombreCompleto = nombreCompleto;
        this.nombreDeporte = nombreDeporte;
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
