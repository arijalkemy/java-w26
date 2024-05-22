package com.w26.elasticsearch.elasticsearch.entity;


import org.springframework.data.elasticsearch.annotations.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Document(indexName = "employee")
public class Employee {
    
    String id;

    private String name;
    private String lastName;

    private Integer age;

    private String city;

    private String province;
}
