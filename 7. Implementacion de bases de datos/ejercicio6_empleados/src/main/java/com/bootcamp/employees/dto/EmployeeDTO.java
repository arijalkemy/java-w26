package com.bootcamp.employees.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDTO implements Serializable {

    private String id;
    private String name;

    @JsonProperty("last_name")
    private String lastName;
    private Integer age;

    private String city;

    @JsonAlias({"department", "province", "state"})
    private String department;

}
