package com.spring.deportistas.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Persona {
    private String nombre;
    private String apellido;
    private List<Deporte> deporteList;
    private int edad;

}
