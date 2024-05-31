package com.example.dto_y_response_entityp2.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data@NoArgsConstructor@AllArgsConstructor
public class PersonDTO {
    @JsonProperty("nombre")
    private String name;
    @JsonProperty("apellido")
    private String lastName;
}
