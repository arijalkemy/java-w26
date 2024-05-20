package com.implbd.crudStudentsJPA.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;

@AllArgsConstructor
@Getter
public class StudentRequestDTO implements Serializable {

    @NotBlank
    private String dni;

    @NotBlank
    private String name;

    @NotBlank
    private String lastName;

}
