package org.bootcamp.covid.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class PersonDTO {
    private String name;
    private String lastName;
    private List<SymptomDTO> symptoms;
}
