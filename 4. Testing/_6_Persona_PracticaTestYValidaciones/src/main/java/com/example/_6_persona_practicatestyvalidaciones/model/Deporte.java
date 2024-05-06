package com.example._6_persona_practicatestyvalidaciones.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Deporte {
    private String nombre;
    private int nivel;
}
