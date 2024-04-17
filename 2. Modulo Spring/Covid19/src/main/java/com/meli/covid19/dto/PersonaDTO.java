package com.meli.covid19.dto;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PersonaDTO implements Serializable {
    private Integer id;
    private String nombre;
    private String apellido;
    private Integer edad;

    private List<SintomaDTO> sintomas;

    public PersonaDTO(Integer id, String nombre, String apellido, Integer edad) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.sintomas =  new ArrayList<>();
    }

    public PersonaDTO(Integer id, String nombre, String apellido, Integer edad, List<SintomaDTO> sintomas) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.sintomas = sintomas;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public String obtenerRiesgo(){
        if(this.edad > 60 && sintomas.size()>0){
            return "Alto";
        }else {
            return "Bajo";
        }
    }


}
