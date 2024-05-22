package com.bootcamp.JPAImplementation.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties
public class StudentDto {

    private Long id;
    private String identification;
    private String name;
    private String lastName;
    private List<Double> califications;
    private Double average;

}
