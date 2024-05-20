package org.example.crud_jpa.dto;

import lombok.Data;

@Data
public class StudentResponseDTO {
    private Long id;
    private String dni;
    private String name;
    private String lastname;
}
