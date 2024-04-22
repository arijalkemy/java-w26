package com.bootcamp.covid19.dto;

import com.bootcamp.covid19.entity.Consulta;
import lombok.Data;

import java.util.List;

@Data
public class RiskPersonDTO {
    private String fullName;
    private int age;
    private List<String> symptomName;

    public RiskPersonDTO(Consulta consulta) {
        this.fullName = consulta.getPersona().getNombre() + " " + consulta.getPersona().getApellido();
        this.age = consulta.getPersona().getEdad();
        this.symptomName = consulta.getSintomas().stream().map(sintoma -> sintoma.getNombre()).toList();
    }
}
