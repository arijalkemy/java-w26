package org.example.empleados.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "workers")
@Data
public class Employee {
    @Id
    String id;
    String firstname;
    String lastname;
    String city;
    String state;
}