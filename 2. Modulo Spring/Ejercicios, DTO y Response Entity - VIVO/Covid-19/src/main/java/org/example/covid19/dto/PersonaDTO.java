package org.example.covid19.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonaDTO implements Serializable {
    private long id;
    private String nombre;
    private String apellido;
    private int edad;
    private List<String> sintomas;
}
