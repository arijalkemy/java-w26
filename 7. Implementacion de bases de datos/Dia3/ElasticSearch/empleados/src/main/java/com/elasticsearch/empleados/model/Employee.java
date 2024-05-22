package com.elasticsearch.empleados.model;

import lombok.Data;
import org.springframework.data.elasticsearch.annotations.Document;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Document(indexName = "employees")
@Data
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private String id;

    private String firstName;
    private String lastName;
    private Integer edad;
    private String city;
    private String state;
}
