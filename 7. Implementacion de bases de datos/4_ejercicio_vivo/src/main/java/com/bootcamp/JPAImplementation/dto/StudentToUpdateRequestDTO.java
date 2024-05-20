package com.bootcamp.JPAImplementation.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentToUpdateRequestDTO {
    private Long id;
    private String identification;
    private String name;
    private String lastName;
}
