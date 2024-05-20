package org.example.crud_jpa.dto;

import lombok.Data;

@Data
public class StudentRequestDTO {
    private String dni;
    private String name;
    private String lastname;
}
