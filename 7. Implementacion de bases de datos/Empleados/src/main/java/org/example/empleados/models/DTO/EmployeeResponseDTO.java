package org.example.empleados.models.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeResponseDTO {
    private String id;
    private String name;
    private String lastName;
    private Integer age;
    private String city;
    private String department;
}
