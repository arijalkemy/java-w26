package org.example.integradorstudentjpa.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StudentUpdateDTO {
    private Long id;
    private String dni;
    private String name;
    private String surname;
}
