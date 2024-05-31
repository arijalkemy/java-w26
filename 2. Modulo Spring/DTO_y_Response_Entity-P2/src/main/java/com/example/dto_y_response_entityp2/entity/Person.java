package com.example.dto_y_response_entityp2.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data@AllArgsConstructor@NoArgsConstructor
public class Person {
    private Long id;
    @JsonProperty("nombre")
    private String name;
    @JsonProperty("apellido")
    private String lastName;
    @JsonProperty("edad")
    private Integer age;
}
