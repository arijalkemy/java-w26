package org.example.ejerciciocovid19.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
@AllArgsConstructor
@Setter
@Getter
public class PatientDTO {
    private String name;
    private String lastName;
    private int age;
    private  String  symptomName;
}
