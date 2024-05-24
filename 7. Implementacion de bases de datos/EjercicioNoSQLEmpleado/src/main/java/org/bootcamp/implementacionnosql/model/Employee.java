package org.bootcamp.implementacionnosql.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Getter @Setter
@Document(indexName = "employee")
public class Employee {
    @Id
    private String id;
    private String name;
    private String surname;
    private Integer age;
    private String city;
    private String place;
}
