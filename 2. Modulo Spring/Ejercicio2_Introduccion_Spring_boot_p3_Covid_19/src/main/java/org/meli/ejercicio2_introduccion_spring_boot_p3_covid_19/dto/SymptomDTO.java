package org.meli.ejercicio2_introduccion_spring_boot_p3_covid_19.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SymptomDTO {
    private String symptom;
    private String severity_level;
}
