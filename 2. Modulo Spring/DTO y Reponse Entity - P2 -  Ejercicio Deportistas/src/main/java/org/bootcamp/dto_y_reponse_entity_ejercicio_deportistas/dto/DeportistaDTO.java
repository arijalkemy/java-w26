package org.bootcamp.dto_y_reponse_entity_ejercicio_deportistas.dto;

import java.io.Serializable;

public class DeportistaDTO implements Serializable {
    private String nombrePersona;
    private String apellido;
    private String nombreDeporte;

    public String getNombrePersona() {
        return nombrePersona;
    }

    public void setNombrePersona(String nombrePersona) {
        this.nombrePersona = nombrePersona;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombreDeporte() {
        return nombreDeporte;
    }

    public void setNombreDeporte(String nombreDeporte) {
        this.nombreDeporte = nombreDeporte;
    }
}
