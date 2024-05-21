package org.example.empleados.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class EmployeeRequestDTO {
    String firstname;
    String lastname;
    String city;
    String state;
}
