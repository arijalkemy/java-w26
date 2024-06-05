package org.meli.ejercicio2_introduccion_spring_boot_p3_covid_19.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {
    @JsonIgnore
    private Long id;
    private String name;
    private String last_name;
    private Integer age;
}
