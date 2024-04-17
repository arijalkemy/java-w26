package com.example.dto_y_response_entityp2_covid.dto;

import com.example.dto_y_response_entityp2_covid.entity.Sintoma;
import lombok.Data;

import java.io.Serializable;

@Data
public class PersonaDTO implements Serializable {
    private String nombre;
    private String apellido;
    private Integer edad;
    private Sintoma sintoma;

}
