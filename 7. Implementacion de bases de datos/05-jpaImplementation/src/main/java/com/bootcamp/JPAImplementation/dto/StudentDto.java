package com.bootcamp.JPAImplementation.dto;

import lombok.Data;

import java.util.List;

@Data
public class StudentDto {

    private Long id;
    private String identification;
    private String name;
    private String lastName;
    private List<Double> califications;
    private Double average;

}
