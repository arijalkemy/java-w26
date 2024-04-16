package com.example._05_covid19.model.DTO;

import com.example._05_covid19.model.Sintoma;

import java.util.ArrayList;
import java.util.List;

public class PersonaConSintomaDTO {
    private String nombre;
    private String apellido;
    private List<String> nombresDeSintomas;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public List<String> getNombresDeSintomas() {
        return nombresDeSintomas;
    }

    public void setNombresDeSintomas(List<String> nombresDeSintomas) {
        this.nombresDeSintomas = nombresDeSintomas;
    }
    public PersonaConSintomaDTO() {
        this.nombresDeSintomas = new ArrayList<>();
    }
    public PersonaConSintomaDTO(String nombre, String apellido, List<String> nombresDeSintomas) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.nombresDeSintomas = nombresDeSintomas;
    }
}
