package org.meli.ejercicio2_introduccion_spring_boot_p3_covid_19.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Symptom {
    @JsonIgnore
    private Long id;
    private String symptom;
    private String severity_level;
    @JsonIgnore
    private Set<Person> persons;
    @JsonIgnore
    private Set<Person> personsCritical;
}
