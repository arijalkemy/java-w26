package org.bootcamp.deportes.restcontroller.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.bootcamp.deportes.domain.Deporte;
import org.bootcamp.deportes.domain.Persona;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class DeportistasDTO {

    private String nombreDeporte;
    private String nombrePersona;
    private String apellidoPersona;

    public DeportistasDTO(String nombreDeporte, String nombrePersona, String apellidoPersona) {
        this.nombreDeporte = nombreDeporte;
        this.nombrePersona = nombrePersona;
        this.apellidoPersona = apellidoPersona;
    }

    public String getNombreDeporte() {
        return nombreDeporte;
    }

    public void setNombreDeporte(String nombreDeporte) {
        this.nombreDeporte = nombreDeporte;
    }

    public String getNombrePersona() {
        return nombrePersona;
    }

    public void setNombrePersona(String nombrePersona) {
        this.nombrePersona = nombrePersona;
    }

    public String getApellidoPersona() {
        return apellidoPersona;
    }

    public void setApellidoPersona(String apellidoPersona) {
        this.apellidoPersona = apellidoPersona;
    }
}
