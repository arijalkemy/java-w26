package com.implbd.crudStudentsJPA.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;

@AllArgsConstructor
@Getter
public class StudentResponseDTO implements Serializable {

    private Long id;
    private String dni;
    private String name;
    private String lastName;

}
