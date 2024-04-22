package com.bootcamp.covid19.entity;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Enfermedad {

    private List<Sintoma> sintomas;

    public Enfermedad() {
        sintomas = new ArrayList<>(
                List.of(
                        new Sintoma("S1", "Fiebre", "Alto"),
                        new Sintoma("S2", "Tos seca", "Medio"),
                        new Sintoma("S3", "Cansancio", "Bajo"),
                        new Sintoma("S4","Escalofrios","Medio")
                )
        );
    }
}
