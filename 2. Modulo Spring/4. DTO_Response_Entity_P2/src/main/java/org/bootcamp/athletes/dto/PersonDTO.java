package org.bootcamp.athletes.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PersonDTO {
    private String name;
    private String lastName;
    private String sport;
}
