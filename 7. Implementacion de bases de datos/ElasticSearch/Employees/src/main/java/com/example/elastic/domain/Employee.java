package com.example.elastic.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;

@Document(indexName = "employee")
@Getter @Setter
public class Employee {
    @Id
    private int id;
    private String name;
    @Field(name = "last_name")
    private String lastName;
    private Integer age;
    private String city;
    private String state;
}
