package org.example.elastic.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(indexName = "employee")
public class Employee {
    private String id;
    @JsonProperty("first_name")
    @Field(name = "first_name")
    private String firstName;
    @JsonProperty("last_name")
    @Field(name = "last_name")
    private String lastName;
    private Integer age;
    private String city;
    private String department;
}
